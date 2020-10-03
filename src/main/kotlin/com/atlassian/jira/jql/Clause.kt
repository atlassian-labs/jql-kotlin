package com.atlassian.jira.jql

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
        toJql()
            // In case the clause to which the order is applied to is effectively empty,
            // the resulting JQL string should be empty as well
            .takeIf { it.isNotBlank() }
            ?.let { clause ->
                fieldsWithOrder.joinToString(separator = ", ") { it.toJql() }
                    .takeIf { it.isNotBlank() }
                    ?.let { orderBy -> "$clause ORDER BY $orderBy" }
            }
            ?: ""

    override fun toJql() = jql

    companion object {
        fun empty() = Clause("")
    }
}
