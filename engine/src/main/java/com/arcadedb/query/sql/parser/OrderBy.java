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
/* Generated By:JJTree: Do not edit this line. OOrderBy.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.Result;
import com.arcadedb.query.sql.executor.ResultInternal;

import java.util.*;
import java.util.stream.*;

public class OrderBy extends SimpleNode {
  protected List<OrderByItem> items;

  public OrderBy() {
    super(-1);
  }

  public OrderBy(int id) {
    super(id);
  }

  public OrderBy(SqlParser p, int id) {
    super(p, id);
  }

  public List<OrderByItem> getItems() {
    return items;
  }

  public void setItems(List<OrderByItem> items) {
    this.items = items;
  }

  public void toString(Map<String, Object> params, StringBuilder builder) {
    if (items != null && items.size() > 0) {
      builder.append("ORDER BY ");
      for (int i = 0; i < items.size(); i++) {
        if (i > 0) {
          builder.append(", ");
        }
        items.get(i).toString(params, builder);
      }
    }
  }

  public int compare(Result a, Result b, CommandContext ctx) {
    for (OrderByItem item : items) {
      int result = item.compare(a, b, ctx);
      if (result != 0) {
        return result > 0 ? 1 : -1;
      }
    }
    return 0;
  }

  public OrderBy copy() {
    OrderBy result = new OrderBy(-1);
    result.items = items == null ? null : items.stream().map(x -> x.copy()).collect(Collectors.toList());
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    OrderBy oOrderBy = (OrderBy) o;

    return items != null ? items.equals(oOrderBy.items) : oOrderBy.items == null;
  }

  @Override
  public int hashCode() {
    return items != null ? items.hashCode() : 0;
  }

  public void extractSubQueries(SubQueryCollector collector) {
    if (items != null) {
      for (OrderByItem item : items) {
        item.extractSubQueries(collector);
      }
    }
  }

  public boolean refersToParent() {
    if (items != null) {
      for (OrderByItem item : items) {
        if (item.refersToParent()) {
          return true;
        }
      }
    }
    return false;
  }

  public Result serialize() {
    ResultInternal result = new ResultInternal();
    if (items != null) {
      result.setProperty("items", items.stream().map(x -> x.serialize()).collect(Collectors.toList()));
    }
    return result;
  }

  public void deserialize(Result fromResult) {

    if (fromResult.getProperty("items") != null) {
      List<Result> ser = fromResult.getProperty("items");
      items = new ArrayList<>();
      for (Result r : ser) {
        OrderByItem exp = new OrderByItem();
        exp.deserialize(r);
        items.add(exp);
      }
    }
  }
}
/* JavaCC - OriginalChecksum=d5529400217169f15e556e5dc6fe4f5b (do not edit this line) */
