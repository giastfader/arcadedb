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

package com.arcadedb.index;

import com.arcadedb.database.Document;
import com.arcadedb.database.Identifiable;
import com.arcadedb.database.RID;
import com.arcadedb.index.lsm.LSMTreeIndexAbstract;
import com.arcadedb.schema.SchemaImpl;

/**
 * Basic Index interface.
 */
public interface Index {
  interface BuildIndexCallback {
    void onDocumentIndexed(Document document, long totalIndexed);
  }

  /**
   * Retrieves the set of RIDs associated to a key.
   */
  IndexCursor get(Object[] keys);

  /**
   * Retrieves the set of RIDs associated to a key with a limit for the result.
   */
  IndexCursor get(Object[] keys, int limit);

  /**
   * Add multiple values for one key in the index.
   *
   * @param keys
   * @param rid  as an array of RIDs
   */
  void put(Object[] keys, RID[] rid);

  /**
   * Removes the keys from the index.
   *
   * @param keys
   */
  void remove(Object[] keys);

  /**
   * Removes an entry keys/record entry from the index.
   */
  void remove(Object[] keys, Identifiable rid);

  long countEntries();

  boolean isCompacting();

  boolean scheduleCompaction();

  SchemaImpl.INDEX_TYPE getType();

  String getTypeName();

  String[] getPropertyNames();

  String getName();

  LSMTreeIndexAbstract.NULL_STRATEGY getNullStrategy();

  void setNullStrategy(LSMTreeIndexAbstract.NULL_STRATEGY nullStrategy);

  boolean isUnique();

  int getAssociatedBucketId();

  boolean supportsOrderedIterations();

  boolean isAutomatic();

  long build(BuildIndexCallback callback);
}
