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
/* Generated By:JJTree: Do not edit this line. OCollection.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Record;
import com.arcadedb.exception.CommandExecutionException;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.Result;
import com.arcadedb.query.sql.executor.ResultInternal;

import java.util.*;
import java.util.stream.*;

public class PCollection extends SimpleNode {
  protected List<Expression> expressions = new ArrayList<Expression>();

  public PCollection(int id) {
    super(id);
  }

  public PCollection(SqlParser p, int id) {
    super(p, id);
  }

  public void toString(Map<String, Object> params, StringBuilder builder) {
    builder.append("[");
    boolean first = true;
    for (Expression expr : expressions) {
      if (!first) {
        builder.append(", ");
      }
      expr.toString(params, builder);
      first = false;
    }
    builder.append("]");
  }

  public void add(Expression exp) {
    this.expressions.add(exp);
  }

  public Object execute(Record iCurrentRecord, CommandContext ctx) {
    List<Object> result = new ArrayList<Object>();
    for (Expression exp : expressions) {
      result.add(exp.execute(iCurrentRecord, ctx));
    }
    return result;
  }

  public Object execute(Result iCurrentRecord, CommandContext ctx) {
    List<Object> result = new ArrayList<Object>();
    for (Expression exp : expressions) {
      result.add(exp.execute(iCurrentRecord, ctx));
    }
    return result;
  }

  public boolean needsAliases(Set<String> aliases) {
    for (Expression expr : this.expressions) {
      if (expr.needsAliases(aliases)) {
        return true;
      }
    }
    return false;
  }

  public boolean isAggregate() {
    for (Expression exp : this.expressions) {
      if (exp.isAggregate()) {
        return true;
      }
    }
    return false;
  }

  public PCollection splitForAggregation(AggregateProjectionSplit aggregateProj) {
    if (isAggregate()) {
      PCollection result = new PCollection(-1);
      for (Expression exp : this.expressions) {
        if (exp.isAggregate() || exp.isEarlyCalculated()) {
          result.expressions.add(exp.splitForAggregation(aggregateProj));
        } else {
          throw new CommandExecutionException("Cannot mix aggregate and non-aggregate operations in a collection: " + this);
        }
      }
      return result;
    } else {
      return this;
    }
  }

  public boolean isEarlyCalculated() {
    for (Expression exp : expressions) {
      if (!exp.isEarlyCalculated()) {
        return false;
      }
    }
    return true;
  }

  public PCollection copy() {
    PCollection result = new PCollection(-1);
    result.expressions = expressions == null ? null : expressions.stream().map(x -> x.copy()).collect(Collectors.toList());
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    PCollection that = (PCollection) o;

    return expressions != null ? expressions.equals(that.expressions) : that.expressions == null;
  }

  @Override
  public int hashCode() {
    return expressions != null ? expressions.hashCode() : 0;
  }

  public boolean refersToParent() {
    if (expressions != null) {
      for (Expression exp : expressions) {
        if (exp != null && exp.refersToParent()) {
          return true;
        }
      }
    }
    return false;
  }

  public Result serialize() {
    ResultInternal result = new ResultInternal();
    if (expressions != null) {
      result.setProperty("expressions", expressions.stream().map(x -> x.serialize()).collect(Collectors.toList()));
    }
    return result;
  }

  public void deserialize(Result fromResult) {
    if (fromResult.getProperty("expressions") != null) {
      expressions = new ArrayList<>();
      List<Result> ser = fromResult.getProperty("expressions");
      for (Result item : ser) {
        Expression exp = new Expression(-1);
        exp.deserialize(item);
        expressions.add(exp);
      }
    }
  }

  public boolean isCacheable() {
    for (Expression exp : expressions) {
      if (!exp.isCacheable()) {
        return false;
      }
    }
    return true;
  }

  public List<Expression> getExpressions() {
    return expressions;
  }
}
/* JavaCC - OriginalChecksum=c93b20138b2ae58c5f76e458c34b5946 (do not edit this line) */
