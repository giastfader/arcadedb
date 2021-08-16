/*
 * Copyright 2021 Arcade Data Ltd
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.arcadedb.server.ha;

import com.arcadedb.GlobalConfiguration;
import com.arcadedb.log.LogManager;
import com.arcadedb.server.ArcadeDBServer;
import com.arcadedb.server.TestCallback;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;

public class ReplicationServerReplicaRestartForceDbInstallIT extends ReplicationServerIT {
  private final    AtomicLong totalMessages           = new AtomicLong();
  private volatile boolean    firstTimeServerShutdown = true;
  private volatile boolean    slowDown                = true;
  private          boolean    hotResync               = false;
  private          boolean    fullResync              = false;

  public ReplicationServerReplicaRestartForceDbInstallIT() {
    GlobalConfiguration.HA_QUORUM.setValue("MAJORITY");
    GlobalConfiguration.HA_REPLICATION_QUEUE_SIZE.setValue(10);
  }

  @AfterEach
  @Override
  public void endTest() {
    super.endTest();
    GlobalConfiguration.HA_REPLICATION_QUEUE_SIZE.setValue(512);
  }

  @Override
  protected void onAfterTest() {
    Assertions.assertFalse(hotResync);
    Assertions.assertTrue(fullResync);
  }

  @Override
  protected void onBeforeStarting(final ArcadeDBServer server) {
    if (server.getServerName().equals("ArcadeDB_2"))
      server.registerTestEventListener(new TestCallback() {
        @Override
        public void onEvent(final TYPE type, final Object object, final ArcadeDBServer server) {
          if (slowDown) {
            // SLOW DOWN A SERVER AFTER 5TH MESSAGE
            if (totalMessages.incrementAndGet() > 5) {
              try {
                LogManager.instance().log(this, Level.INFO, "TEST: Slowing down response from replica server 2...");
                Thread.sleep(10000);
              } catch (InterruptedException e) {
                // IGNORE IT
                Thread.currentThread().interrupt();
              }
            }
          } else {
            if (type == TYPE.REPLICA_HOT_RESYNC) {
              LogManager.instance().log(this, Level.INFO, "TEST: Received hot resync request");
              hotResync = true;
            } else if (type == TYPE.REPLICA_FULL_RESYNC) {
              LogManager.instance().log(this, Level.INFO, "TEST: Received full resync request");
              fullResync = true;
            }
          }
        }
      });

    if (server.getServerName().equals("ArcadeDB_0"))
      server.registerTestEventListener(new TestCallback() {
        @Override
        public void onEvent(final TYPE type, final Object object, final ArcadeDBServer server) {
          // SLOW DOWN A SERVER
          if ("ArcadeDB_2".equals(object) && type == TYPE.REPLICA_OFFLINE && firstTimeServerShutdown) {
            LogManager.instance().log(this, Level.INFO, "TEST: Stopping Replica 2, removing latency, delete the replication log file and restart the server...");
            slowDown = false;
            firstTimeServerShutdown = false;

            executeAsynchronously(new Callable() {
              @Override
              public Object call() {
                getServer(2).stop();
                GlobalConfiguration.HA_REPLICATION_QUEUE_SIZE.setValue(512);
                try {
                  Thread.sleep(1000);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
                Assertions.assertTrue(new File("./target/replication/replication_ArcadeDB_2.rlog.0").exists());
                new File("./target/replication/replication_ArcadeDB_2.rlog.0").delete();
                getServer(2).start();
                return null;
              }
            });
          }
        }
      });
  }
}
