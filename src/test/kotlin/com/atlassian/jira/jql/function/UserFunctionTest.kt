package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class UserFunctionTest {
    @Test
    fun `currentUser function`() = assertJql(
        currentUser(),
        expectedJql = "currentUser()"
    )

    @Test
    fun `membersOf function`() =
        assertJql(
            membersOf("foo"),
            expectedJql = """membersOf("foo")"""
        )
}
