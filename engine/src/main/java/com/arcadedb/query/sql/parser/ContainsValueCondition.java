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

/* Generated By:JJTree: Do not edit this line. OContainsValueCondition.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Identifiable;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.Result;

import java.util.*;

public class ContainsValueCondition extends BooleanExpression {
  protected Expression            left;
  protected ContainsValueOperator operator;
  protected OrBlock               condition;
  protected Expression            expression;

  public ContainsValueCondition(int id) {
    super(id);
  }

  public ContainsValueCondition(SqlParser p, int id) {
    super(p, id);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(SqlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public boolean evaluate(Identifiable currentRecord, CommandContext ctx) {
    Object leftValue = left.execute(currentRecord, ctx);
    if (leftValue instanceof Map) {
      Map map = (Map) leftValue;
      if (condition != null) {
        for (Object o : map.values()) {
          if (condition.evaluate(o, ctx)) {
            return true;
          }
        }
        return false;
      } else {
        Object rightValue = expression.execute(currentRecord, ctx);
        return map.values().contains(rightValue);//TODO type conversions...?
      }

    }
    return false;
  }

  @Override
  public boolean evaluate(Result currentRecord, CommandContext ctx) {
    Object leftValue = left.execute(currentRecord, ctx);
    if (leftValue instanceof Map) {
      Map map = (Map) leftValue;
      if (condition != null) {
        for (Object o : map.values()) {
          if (condition.evaluate(o, ctx)) {
            return true;
          }
        }
        return false;
      } else {
        Object rightValue = expression.execute(currentRecord, ctx);
        return map.values().contains(rightValue);//TODO type conversions...?
      }

    }
    return false;
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {

    left.toString(params, builder);
    builder.append(" CONTAINSVALUE ");
    if (condition != null) {
      builder.append("(");
      condition.toString(params, builder);
      builder.append(")");
    } else {
      expression.toString(params, builder);
    }

  }

  @Override
  public boolean supportsBasicCalculation() {
    return true;
  }

  @Override
  protected int getNumberOfExternalCalculations() {
    if (condition == null) {
      return 0;
    }
    return condition.getNumberOfExternalCalculations();
  }

  @Override
  protected List<Object> getExternalCalculationConditions() {
    if (condition == null) {
      return Collections.EMPTY_LIST;
    }
    return condition.getExternalCalculationConditions();
  }

  @Override
  public boolean needsAliases(Set<String> aliases) {
    if (left != null && left.needsAliases(aliases)) {
      return true;
    }
    if (condition != null && condition.needsAliases(aliases)) {
      return true;
    }
    return expression != null && expression.needsAliases(aliases);

  }

  @Override
  public ContainsValueCondition copy() {
    ContainsValueCondition result = new ContainsValueCondition(-1);
    result.left = left.copy();
    result.operator = operator;
    result.condition = condition == null ? null : condition.copy();
    result.expression = expression == null ? null : expression.copy();
    return result;
  }

  @Override
  public void extractSubQueries(SubQueryCollector collector) {
    left.extractSubQueries(collector);
    if (condition != null) {
      condition.extractSubQueries(collector);
    }
    if (expression != null) {
      expression.extractSubQueries(collector);
    }
  }

  @Override
  public boolean refersToParent() {
    if (left != null && left.refersToParent()) {
      return true;
    }
    if (condition != null && condition.refersToParent()) {
      return true;
    }
    return expression != null && condition.refersToParent();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ContainsValueCondition that = (ContainsValueCondition) o;

    if (left != null ? !left.equals(that.left) : that.left != null)
      return false;
    if (operator != null ? !operator.equals(that.operator) : that.operator != null)
      return false;
    if (condition != null ? !condition.equals(that.condition) : that.condition != null)
      return false;
    return expression != null ? expression.equals(that.expression) : that.expression == null;
  }

  @Override
  public int hashCode() {
    int result = left != null ? left.hashCode() : 0;
    result = 31 * result + (operator != null ? operator.hashCode() : 0);
    result = 31 * result + (condition != null ? condition.hashCode() : 0);
    result = 31 * result + (expression != null ? expression.hashCode() : 0);
    return result;
  }

  @Override
  public List<String> getMatchPatternInvolvedAliases() {
    List<String> leftX = left == null ? null : left.getMatchPatternInvolvedAliases();
    List<String> expressionX = expression == null ? null : expression.getMatchPatternInvolvedAliases();
    List<String> conditionX = condition == null ? null : condition.getMatchPatternInvolvedAliases();

    List<String> result = new ArrayList<String>();
    if (leftX != null) {
      result.addAll(leftX);
    }
    if (expressionX != null) {
      result.addAll(expressionX);
    }
    if (conditionX != null) {
      result.addAll(conditionX);
    }

    return result.size() == 0 ? null : result;
  }

  @Override
  public boolean isCacheable() {
    if (left != null && !left.isCacheable()) {
      return false;
    }
    if (condition != null && !condition.isCacheable()) {
      return false;
    }
    return expression == null || expression.isCacheable();
  }
}
/* JavaCC - OriginalChecksum=6fda752f10c8d8731f43efa706e39459 (do not edit this line) */
