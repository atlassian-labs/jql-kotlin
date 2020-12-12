package com.atlassian.jira.jql

class NotClause(clause: Clause) : Clause(
    clause.toJql()
        .takeIf { it.isNotBlank() }
        ?.let { "NOT $it" }
        ?: ""
)

fun not(clause: Clause): Clause = NotClause(clause)
fun not(clause: () -> Clause): Clause = NotClause(clause.asClause())
