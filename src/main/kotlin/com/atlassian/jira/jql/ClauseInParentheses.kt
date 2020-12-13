package com.atlassian.jira.jql

fun (() -> Clause).asClause() = Clause(
    invoke().toJql()
        // If the clause inside of parentheses is effectively empty,
        // the resulting JQL should be empty as well
        .takeIf { it.isNotBlank() }
        ?.let { "($it)" }
        ?: ""
)

infix fun (() -> Clause).and(clause: Clause): Clause =
    CompoundClause(asClause(), Keyword.AND, clause)

infix fun (() -> Clause).and(clause: () -> Clause): Clause =
    CompoundClause(asClause(), Keyword.AND, clause.asClause())

infix fun (() -> Clause).or(clause: Clause): Clause =
    CompoundClause(asClause(), Keyword.OR, clause)

infix fun (() -> Clause).or(clause: () -> Clause): Clause =
    CompoundClause(asClause(), Keyword.OR, clause.asClause())

infix fun (() -> Clause).orderBy(fieldWithOrder: FieldOrder): String =
    asClause().orderBy(fieldWithOrder)

infix fun (() -> Clause).orderBy(fieldsWithOrder: List<FieldOrder>): String =
    asClause().orderBy(fieldsWithOrder)
