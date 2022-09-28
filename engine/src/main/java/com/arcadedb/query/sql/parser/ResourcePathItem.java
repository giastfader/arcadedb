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
/* Generated By:JJTree: Do not edit this line. OResourcePathItem.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import java.util.*;

public class ResourcePathItem extends SimpleNode {
  protected boolean    star = false;
  protected Identifier identifier;
  protected String     name;

  public ResourcePathItem(int id) {
    super(id);
  }

  public ResourcePathItem(SqlParser p, int id) {
    super(p, id);
  }

  @Override
  public void toString(Map<String, Object> params, StringBuilder builder) {
    if (star) {
      builder.append("*");
    } else if (identifier != null) {
      identifier.toString(params, builder);
    } else {
      builder.append(name);
    }
  }

  @Override
  public ResourcePathItem copy() {
    ResourcePathItem result = new ResourcePathItem(-1);
    result.star = star;
    result.identifier = identifier == null ? null : identifier.copy();
    result.name = name;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ResourcePathItem that = (ResourcePathItem) o;

    if (star != that.star)
      return false;
    if (!Objects.equals(identifier, that.identifier))
      return false;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    int result = (star ? 1 : 0);
    result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
/* JavaCC - OriginalChecksum=b90ccdd61b6adcd40cde2adee353e89f (do not edit this line) */
