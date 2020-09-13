package com.atlassian.jira.jql

class NotClause(clause: Clause) : Clause(
    clause.toJql()
        .takeIf { it.isNotBlank() }
        ?.let { "NOT $it" }
        ?: ""
)

@Suppress("ClassName")
object not {
    operator fun invoke(clause: Clause): Clause = NotClause(clause)

    operator fun invoke(clause: () -> Clause): Clause = NotClause(clause.asClause())
}
