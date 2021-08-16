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

/* Generated By:JJTree: Do not edit this line. OUpdateEdgeStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.UpdateExecutionPlan;
import com.arcadedb.query.sql.executor.OUpdateExecutionPlanner;

import java.util.stream.Collectors;

public class UpdateEdgeStatement extends UpdateStatement {
  public UpdateEdgeStatement(int id) {
    super(id);
  }

  public UpdateEdgeStatement(SqlParser p, int id) {
    super(p, id);
  }

  protected String getStatementType() {
    return "UPDATE EDGE ";
  }

  @Override public UpdateExecutionPlan createExecutionPlan(CommandContext ctx, boolean enableProfiling) {
    OUpdateExecutionPlanner planner = new OUpdateExecutionPlanner(this);
    return planner.createExecutionPlan(ctx, enableProfiling);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(SqlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override public UpdateEdgeStatement copy() {
    UpdateEdgeStatement result = new UpdateEdgeStatement(-1);
    result.target = target == null ? null : target.copy();
    result.operations = operations == null ? null : operations.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.upsert = upsert;
    result.returnBefore = returnBefore;
    result.returnAfter = returnAfter;
    result.returnProjection = returnProjection == null ? null : returnProjection.copy();
    result.whereClause = whereClause == null ? null : whereClause.copy();
    result.lockRecord = lockRecord;
    result.limit = limit == null ? null : limit.copy();
    result.timeout = timeout == null ? null : timeout.copy();
    return result;
  }

}
/* JavaCC - OriginalChecksum=496f32976ee84e3a3a89d1410dc134c5 (do not edit this line) */
