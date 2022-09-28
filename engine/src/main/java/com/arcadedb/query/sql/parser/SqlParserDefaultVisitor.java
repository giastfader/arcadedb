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
/* Generated by: ParserGeneratorCC: Do not edit this line. SqlParserDefaultVisitor.java Version 1.1.3 */
package com.arcadedb.query.sql.parser;

public class SqlParserDefaultVisitor implements SqlParserVisitor {
  public Object defaultVisit(final SimpleNode node, final Object data) {
    node.childrenAccept(this, data);
    return data;
  }

  public Object visit(final SimpleNode node, final Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Rid node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(parse node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ParseScript node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(PString node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Identifier node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(PInteger node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(FloatingPoint node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(PNumber node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Statement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(StatementSemicolon node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(StatementInternal node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(QueryStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(SelectWithoutTargetStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(SelectStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(TraverseStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MatchStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteVertexStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteEdgeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteEdgeByRidStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteEdgeFromToStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteEdgeToStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteEdgeVToStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DeleteEdgeWhereStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdateEdgeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdateStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdateOperations node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdateItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdateIncrementItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdateRemoveItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdatePutItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(UpdateAddItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InsertStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InsertBody node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateVertexStatementEmptyNoTarget node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateVertexStatementEmpty node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateVertexStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateVertexStatementNoTarget node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateEdgeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InputParameter node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(PositionalParameter node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NamedParameter node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Projection node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ProjectionItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NestedProjection node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NestedProjectionItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ArraySelector node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ArrayNumberSelector node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ArraySingleValuesSelector node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ArrayRangeSelector node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Alias node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(RecordAttribute node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(FunctionCall node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MethodCall node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(LevelZeroIdentifier node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(SuffixIdentifier node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BaseIdentifier node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Modifier node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Expression node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ArrayConcatExpression node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ArrayConcatExpressionElement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MathExpression node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(FirstLevelExpression node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ParenthesisExpression node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BaseExpression node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(FromClause node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(LetClause node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(LetItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(FromItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Bucket node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BucketList node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(SchemaIdentifier node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IndexIdentifier node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(WhereClause node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(OrBlock node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(AndBlock node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NotBlock node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ParenthesisBlock node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ConditionBlock node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CompareOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(LtOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(GtOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NeOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NeqOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(GeOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(LeOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(LikeOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NearOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(WithinOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ScAndOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ContainsKeyOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ContainsValueOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(EqualsCompareOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(RightBinaryCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BinaryCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ContainsValueCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InstanceofCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IndexMatchCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BetweenCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IsNullCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IsNotNullCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IsDefinedCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IsNotDefinedCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ContainsCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InOperator node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(NotInCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ContainsAllCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ContainsAnyCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ContainsTextCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MatchesCondition node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(OrderBy node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(GroupBy node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Unwind node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Limit node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Skip node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Timeout node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Wait node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Retry node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(PCollection node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(TraverseProjectionItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(Json node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MatchExpression node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MatchPathItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(FieldMatchPathItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MatchPathItemFirst node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MultiMatchPathItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MultiMatchPathItemArrows node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MatchFilter node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(MatchFilterItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(OutPathItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InPathItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BothPathItem node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(OutPathItemOpt node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(InPathItemOpt node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BothPathItemOpt node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(TruncateTypeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(TruncateBucketStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(TruncateRecordStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateDocumentTypeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateVertexTypeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateEdgeTypeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(AlterTypeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DropTypeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IfNotExists node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreatePropertyStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreatePropertyAttributeStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(AlterPropertyStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DropPropertyStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateIndexStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(RebuildIndexStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DropIndexStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CreateBucketStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(AlterBucketStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(DropBucketStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(AlterDatabaseStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CommandLineOption node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ExplainStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ProfileStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(LetStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(BeginStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(CommitStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(RollbackStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ReturnStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(IfStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(SleepStatement node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(ForEachBlock node, Object data) {
    return defaultVisit(node, data);
  }

  public Object visit(WhileBlock node, Object data) {
    return defaultVisit(node, data);
  }
}
/* ParserGeneratorCC - OriginalChecksum=b4d9e905040f8723ce073fb48971de37 (do not edit this line) */
