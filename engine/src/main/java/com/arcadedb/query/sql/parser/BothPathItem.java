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

/* Generated By:JJTree: Do not edit this line. OBothPathItem.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.query.sql.executor.Result;

import java.util.Map;

public class BothPathItem extends MatchPathItem {
  public BothPathItem(int id) {
    super(id);
  }

  public BothPathItem(SqlParser p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(SqlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append("-");
    boolean first = true;
    if (this.method.params != null) {
      for (Expression exp : this.method.params) {
        if (!first) {
          builder.append(", ");
        }
        builder.append(exp.execute((Result) null, null));
        first = false;
      }
    }
    builder.append("-");
    if (filter != null) {
      filter.toString(params, builder);
    }
  }

}
/* JavaCC - OriginalChecksum=061ff26f18cfa0c561ce9b98ef919173 (do not edit this line) */
