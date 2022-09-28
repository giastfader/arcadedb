/*
 * Copyright © 2021-present Arcade Data Ltd (info@arcadedata.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-FileCopyrightText: 2021-present Arcade Data Ltd (info@arcadedata.com)
 * SPDX-License-Identifier: Apache-2.0
 */
/* Generated By:JJTree: Do not edit this line. OCreateEdgeStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Database;
import com.arcadedb.query.sql.executor.BasicCommandContext;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.CreateEdgeExecutionPlanner;
import com.arcadedb.query.sql.executor.InsertExecutionPlan;
import com.arcadedb.query.sql.executor.ResultSet;

import java.util.*;

public class CreateEdgeStatement extends Statement {
  protected Identifier targetType;
  protected Identifier targetBucketName;
  protected Expression leftExpression;
  protected Expression rightExpression;
  protected InsertBody body;
  protected Number     retry;
  protected Number     wait;
  protected boolean    ifNotExists;

  public CreateEdgeStatement(int id) {
    super(id);
  }

  public CreateEdgeStatement(SqlParser p, int id) {
    super(p, id);
  }

  @Override
  public ResultSet execute(Database db, Object[] args, CommandContext parentCtx, boolean usePlanCache) {
    BasicCommandContext ctx = new BasicCommandContext();
    if (parentCtx != null) {
      ctx.setParentWithoutOverridingChild(parentCtx);
    }
    ctx.setDatabase(db);
    ctx.setInputParameters(args);
    InsertExecutionPlan executionPlan = createExecutionPlan(ctx, false);
    executionPlan.executeInternal();
    return new LocalResultSet(executionPlan);
  }

  @Override
  public ResultSet execute(Database db, Map params, CommandContext parentCtx, boolean usePlanCache) {
    BasicCommandContext ctx = new BasicCommandContext();
    if (parentCtx != null) {
      ctx.setParentWithoutOverridingChild(parentCtx);
    }
    ctx.setDatabase(db);
    ctx.setInputParameters(params);
    InsertExecutionPlan executionPlan = createExecutionPlan(ctx, false);
    executionPlan.executeInternal();
    return new LocalResultSet(executionPlan);
  }

  public InsertExecutionPlan createExecutionPlan(CommandContext ctx, boolean enableProfiling) {
    CreateEdgeExecutionPlanner planner = new CreateEdgeExecutionPlanner(this);
    return planner.createExecutionPlan(ctx, enableProfiling);
  }

  public void toString(Map<String, Object> params, StringBuilder builder) {
    builder.append("CREATE EDGE");
    if (targetType != null) {
      builder.append(" ");
      targetType.toString(params, builder);
      if (targetBucketName != null) {
        builder.append(" BUCKET ");
        targetBucketName.toString(params, builder);
      }
    }
    builder.append(" FROM ");
    leftExpression.toString(params, builder);

    builder.append(" TO ");
    rightExpression.toString(params, builder);

    if (ifNotExists)
      builder.append(" IF NOT EXISTS");

    if (body != null) {
      builder.append(" ");
      body.toString(params, builder);
    }
    if (retry != null) {
      builder.append(" RETRY ");
      builder.append(retry);
    }
    if (wait != null) {
      builder.append(" WAIT ");
      builder.append(wait);
    }
  }

  @Override
  public CreateEdgeStatement copy() {
    final CreateEdgeStatement result = new CreateEdgeStatement(-1);
    result.targetType = targetType == null ? null : targetType.copy();
    result.targetBucketName = targetBucketName == null ? null : targetBucketName.copy();
    result.leftExpression = leftExpression == null ? null : leftExpression.copy();
    result.rightExpression = rightExpression == null ? null : rightExpression.copy();
    result.ifNotExists = ifNotExists;
    result.body = body == null ? null : body.copy();
    result.retry = retry;
    result.wait = wait;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    final CreateEdgeStatement that = (CreateEdgeStatement) o;

    if (targetType != null ? !targetType.equals(that.targetType) : that.targetType != null)
      return false;
    if (targetBucketName != null ? !targetBucketName.equals(that.targetBucketName) : that.targetBucketName != null)
      return false;
    if (leftExpression != null ? !leftExpression.equals(that.leftExpression) : that.leftExpression != null)
      return false;
    if (rightExpression != null ? !rightExpression.equals(that.rightExpression) : that.rightExpression != null)
      return false;
    if (ifNotExists != that.ifNotExists)
      return false;
    if (body != null ? !body.equals(that.body) : that.body != null)
      return false;
    if (retry != null ? !retry.equals(that.retry) : that.retry != null)
      return false;
    return wait != null ? wait.equals(that.wait) : that.wait == null;
  }

  @Override
  public int hashCode() {
    int result = targetType != null ? targetType.hashCode() : 0;
    result = 31 * result + (targetBucketName != null ? targetBucketName.hashCode() : 0);
    result = 31 * result + (leftExpression != null ? leftExpression.hashCode() : 0);
    result = 31 * result + (rightExpression != null ? rightExpression.hashCode() : 0);
    result = 31 * result + (ifNotExists ? 1 : 0);
    result = 31 * result + (body != null ? body.hashCode() : 0);
    result = 31 * result + (retry != null ? retry.hashCode() : 0);
    result = 31 * result + (wait != null ? wait.hashCode() : 0);
    return result;
  }

  public Identifier getTargetType() {
    return targetType;
  }

  public Identifier getTargetBucketName() {
    return targetBucketName;
  }

  public Expression getLeftExpression() {
    return leftExpression;
  }

  public Expression getRightExpression() {
    return rightExpression;
  }

  public boolean ifNotExists() {
    return ifNotExists;
  }

  public InsertBody getBody() {
    return body;
  }

  public Number getRetry() {
    return retry;
  }

  public Number getWait() {
    return wait;
  }
}
/* JavaCC - OriginalChecksum=2d3dc5693940ffa520146f8f7f505128 (do not edit this line) */
