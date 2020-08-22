package com.atlassian.jira.jql

open class Clause(private val jql: String) : JqlEntity {
    operator fun unaryMinus(): Clause = NotClause(this)

    infix fun and(clause: Clause): Clause =
        CompoundClause(this, Keyword.AND, clause)

    infix fun and(clause: () -> Clause): Clause =
        CompoundClause(this, Keyword.AND, clause.asClause())

    infix fun or(clause: Clause): Clause =
        CompoundClause(this, Keyword.OR, clause)

    infix fun or(clause: () -> Clause): Clause =
        CompoundClause(this, Keyword.OR, clause.asClause())

    // TODO support multi order
    infix fun orderBy(fieldWithOrder: FieldOrder): String =
        toJql()
            // In case the clause to which the order is applied to is effectively empty,
            // the resulting JQL string should be empty as well
            .takeIf { it.isNotBlank() }
            ?.let { "$it order by ${fieldWithOrder.toJql()}" }
            ?: ""

    override fun toJql() = jql

    companion object {
        fun empty() = Clause("")
    }
}

class NotClause(clause: Clause) : Clause(
    clause.toJql()
        .takeIf { it.isNotBlank() }
        ?.let { "NOT $it" }
        ?: ""
)
