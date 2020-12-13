package com.atlassian.jira.jql

import com.atlassian.jira.jql.orderBy as orderByExpr

open class Clause(private val jql: String) : JqlEntity {
    infix fun and(clause: Clause): Clause =
        CompoundClause(this, Keyword.AND, clause)

    infix fun and(clause: () -> Clause): Clause =
        CompoundClause(this, Keyword.AND, clause.asClause())

    infix fun or(clause: Clause): Clause =
        CompoundClause(this, Keyword.OR, clause)

    infix fun or(clause: () -> Clause): Clause =
        CompoundClause(this, Keyword.OR, clause.asClause())

    infix fun orderBy(fieldWithOrder: FieldOrder): String = orderBy(listOf(fieldWithOrder))

    infix fun orderBy(fieldsWithOrder: List<FieldOrder>): String =
        // ORDER BY on its own is a valid JQL, so even if this clause is effectively empty,
        // we can return ORDER BY as the result
        arrayOf(toJql(), orderByExpr(fieldsWithOrder))
            .filter { it.isNotBlank() }
            .joinToString(separator = " ")

    override fun toJql() = jql

    companion object {
        fun empty() = Clause("")
    }
}
