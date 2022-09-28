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
/* Generated By:JJTree: Do not edit this line. OAlterPropertyStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Database;
import com.arcadedb.database.Identifiable;
import com.arcadedb.exception.CommandExecutionException;
import com.arcadedb.exception.CommandSQLParsingException;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.InternalResultSet;
import com.arcadedb.query.sql.executor.ResultInternal;
import com.arcadedb.query.sql.executor.ResultSet;
import com.arcadedb.schema.DocumentType;
import com.arcadedb.schema.Property;

import java.util.*;

public class AlterPropertyStatement extends DDLStatement {

  public Expression settingValue;

  Identifier typeName;
  Identifier propertyName;
  Identifier customPropertyName;
  Expression customPropertyValue;
  Identifier settingName;

  public AlterPropertyStatement(int id) {
    super(id);
  }

  public AlterPropertyStatement(SqlParser p, int id) {
    super(p, id);
  }

  @Override
  public ResultSet executeDDL(CommandContext ctx) {
    Database db = ctx.getDatabase();
    DocumentType typez = db.getSchema().getType(typeName.getStringValue());

    if (typez == null) {
      throw new CommandExecutionException("Invalid type name or type not found: " + typez);
    }

    final Property property = typez.getProperty(propertyName.getStringValue());
    if (property == null)
      throw new CommandExecutionException("Property '" + property + "' not found on type " + typez);

    ResultInternal result = new ResultInternal();
    result.setProperty("type", typeName.getStringValue());
    result.setProperty("property", propertyName.getStringValue());

    if (customPropertyName != null) {
      String customName = customPropertyName.getStringValue();
      Object oldValue = property.getCustomValue(customName);
      Object finalValue = customPropertyValue.execute((Identifiable) null, ctx);
      property.setCustomValue(customName, finalValue);

      result.setProperty("operation", "alter property custom");
      result.setProperty("customAttribute", customPropertyName.getStringValue());
      result.setProperty("oldValue", oldValue);
      result.setProperty("newValue", finalValue);
    } else if (settingName != null) {
      final String setting = settingName.getStringValue().toLowerCase();
      final Object finalValue = settingValue.execute((Identifiable) null, ctx);

      final Object oldValue;
      switch (setting) {
      case "default":
        oldValue = property.getDefaultValue();
        property.setDefaultValue(finalValue);
        break;

      default:
        throw new CommandExecutionException("Setting '" + setting + "' not supported");
      }

      result.setProperty("operation", "alter property");
      result.setProperty("attribute", setting);
      result.setProperty("oldValue", oldValue);
      result.setProperty("newValue", finalValue);
    } else
      throw new CommandExecutionException("Property '" + property + "' not found on type '" + typez + "'");

    final InternalResultSet rs = new InternalResultSet();
    rs.add(result);
    return rs;
  }

  @Override
  public void validate() throws CommandSQLParsingException {
    super.validate();//TODO
  }

  @Override
  public void toString( final Map<String, Object> params, final StringBuilder builder) {
    builder.append("ALTER PROPERTY ");
    typeName.toString(params, builder);
    builder.append(".");
    propertyName.toString(params, builder);
    if (customPropertyName != null) {
      builder.append(" CUSTOM ");
      customPropertyName.toString(params, builder);
      builder.append(" = ");
      customPropertyValue.toString(params, builder);
    } else {
      builder.append(" ");
      settingName.toString(params, builder);
      builder.append(" ");
      settingValue.toString(params, builder);
    }
  }

  @Override
  public AlterPropertyStatement copy() {
    final AlterPropertyStatement result = new AlterPropertyStatement(-1);
    result.typeName = typeName == null ? null : typeName.copy();
    result.propertyName = propertyName == null ? null : propertyName.copy();
    result.customPropertyName = customPropertyName == null ? null : customPropertyName.copy();
    result.customPropertyValue = customPropertyValue == null ? null : customPropertyValue.copy();
    result.settingName = settingName == null ? null : settingName.copy();
    result.settingValue = settingValue == null ? null : settingValue.copy();
    return result;
  }

  @Override
  public boolean equals( final Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    final AlterPropertyStatement that = (AlterPropertyStatement) o;

    if (!Objects.equals(typeName, that.typeName))
      return false;
    if (!Objects.equals(propertyName, that.propertyName))
      return false;
    if (!Objects.equals(customPropertyName, that.customPropertyName))
      return false;
    if (!Objects.equals(customPropertyValue, that.customPropertyValue))
      return false;
    if (!Objects.equals(settingName, that.settingName))
      return false;
    return Objects.equals(settingValue, that.settingValue);
  }

  @Override
  public int hashCode() {
    int result = typeName != null ? typeName.hashCode() : 0;
    result = 31 * result + (propertyName != null ? propertyName.hashCode() : 0);
    result = 31 * result + (customPropertyName != null ? customPropertyName.hashCode() : 0);
    result = 31 * result + (customPropertyValue != null ? customPropertyValue.hashCode() : 0);
    result = 31 * result + (settingName != null ? settingName.hashCode() : 0);
    result = 31 * result + (settingValue != null ? settingValue.hashCode() : 0);
    return result;
  }
}
/* JavaCC - OriginalChecksum=2421f6ad3b5f1f8e18149650ff80f1e7 (do not edit this line) */
