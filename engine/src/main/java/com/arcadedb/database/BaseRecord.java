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

package com.arcadedb.database;

import com.arcadedb.exception.RecordNotFoundException;
import com.arcadedb.graph.Edge;
import com.arcadedb.graph.Vertex;

public abstract class BaseRecord implements Record {
  protected final DatabaseInternal database;
  protected       RID              rid;
  protected       Binary           buffer;

  protected BaseRecord(final Database database, final RID rid, final Binary buffer) {
    this.database = (DatabaseInternal) database;
    this.rid = rid;
    this.buffer = buffer;
  }

  @Override
  public RID getIdentity() {
    return rid;
  }

  @Override
  public Record getRecord() {
    return this;
  }

  @Override
  public Record getRecord(final boolean loadContent) {
    return this;
  }

  @Override
  public void reload() {
    if (rid != null && buffer == null && database.isOpen()) {
      try {
        buffer = database.getSchema().getBucketById(rid.getBucketId()).getRecord(rid);
      } catch (RecordNotFoundException e) {
        // IGNORE IT
      }
    }
  }

  @Override
  public void delete() {
    database.deleteRecord(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o)
      return true;
    if (o == null || !(o instanceof Identifiable))
      return false;

    final RID pRID = ((Identifiable) o).getIdentity();

    return rid != null ? rid.equals(pRID) : pRID == null;
  }

  @Override
  public int hashCode() {
    int result = database.hashCode();
    result = 31 * result + (rid != null ? rid.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return rid != null ? rid.toString() : "#?:?";
  }

  @Override
  public Database getDatabase() {
    return database;
  }

  public Binary getBuffer() {
    return buffer;
  }

  public void setBuffer(final Binary buffer) {
    this.buffer = buffer;
  }

  @Override
  public Document asDocument() {
    if (this instanceof Edge)
      throw new ClassCastException("Cannot cast an edge to a document");
    if (this instanceof Vertex)
      throw new ClassCastException("Cannot cast a vertex to a document");
    throw new ClassCastException("Current record is not a document");
  }

  @Override
  public Document asDocument(boolean loadContent) {
    if (this instanceof Edge)
      throw new ClassCastException("Cannot cast an edge to a document");
    if (this instanceof Vertex)
      throw new ClassCastException("Cannot cast a vertex to a document");
    throw new ClassCastException("Current record is not a document");
  }

  @Override
  public Vertex asVertex() {
    if (this instanceof Edge)
      throw new ClassCastException("Cannot cast an edge to a vertex");
    if (this instanceof Document)
      throw new ClassCastException("Cannot cast a document to a vertex");
    throw new ClassCastException("Current record is not a vertex");
  }

  @Override
  public Vertex asVertex(final boolean loadContent) {
    if (this instanceof Edge)
      throw new ClassCastException("Cannot cast an edge to a vertex");
    if (this instanceof Document)
      throw new ClassCastException("Cannot cast a document to a vertex");
    throw new ClassCastException("Current record is not a vertex");
  }

  @Override
  public Edge asEdge() {
    if (this instanceof Vertex)
      throw new ClassCastException("Cannot cast a vertex to an edge");
    if (this instanceof Document)
      throw new ClassCastException("Cannot cast a document to an edge");
    throw new ClassCastException("Current record is not a edge");
  }

  @Override
  public Edge asEdge(boolean loadContent) {
    throw new UnsupportedOperationException();
  }
}
