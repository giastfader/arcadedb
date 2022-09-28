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
/* Generated by: JJTree: Do not edit this line. ObjectTypeDefinition.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.arcadedb.graphql.parser;

import java.util.*;

public class ObjectTypeDefinition extends TypeDefinition {

  protected Name                  name;
  protected ImplementsInterface   implementsInterface;
  protected Directives            directives;
  protected List<FieldDefinition> fieldDefinitions = new ArrayList<>();

  public ObjectTypeDefinition(int id) {
    super(id);
  }

  public ObjectTypeDefinition(GraphQLParser p, int id) {
    super(p, id);
  }

  public String getName() {
    return name != null ? name.value : null;
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(GraphQLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public List<FieldDefinition> getFieldDefinitions() {
    return fieldDefinitions;
  }

  public FieldDefinition getFieldDefinitionByName(final String fieldName) {
    for (FieldDefinition f : fieldDefinitions) {
      if (f.getName().equals(fieldName))
        return f;
    }
    return null;
  }

  @Override
  public String treeToString(final String prefix, final Class... excludes) {
    return super.treeToString(prefix, Name.class);
  }

  @Override
  public String toString() {
    return "ObjectTypeDefinition{" + name.value + '}';
  }
}
/* ParserGeneratorCC - OriginalChecksum=22e41e7403da6914e57ff609136bdc3e (do not edit this line) */
