package com.atlassian.jira.jql

import org.junit.jupiter.api.Test

internal class NotClauseTest {
    @Test
    fun `not clause`() = assertJql(
        not(Clause("clause")),
        expectedJql = """NOT clause"""
    )

    @Test
    fun `not clause in parentheses`() = assertJql(
        not { Clause("clause") },
        expectedJql = """NOT (clause)"""
    )
}
