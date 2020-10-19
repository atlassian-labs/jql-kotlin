package com.atlassian.jira.jql

class CompoundClause(
    left: Clause,
    keyword: Keyword,
    right: Clause,
) : Clause(
    arrayOf(left, right)
        // If either of the subclauses are effectively empty, the resulting JQL should
        // equal to the JQL of the non-empty clause. If both subclauses are empty,
        // the resulting JQL should be empty as well.
        .mapNotNull { clause -> clause.toJql().takeIf { it.isNotBlank() } }
        .joinToString(separator = " ${keyword.toJql()} ")
)
