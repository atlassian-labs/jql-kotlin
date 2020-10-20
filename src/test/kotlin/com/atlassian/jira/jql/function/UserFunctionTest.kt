package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserFunctionTest {
    @Test
    fun `currentUser function`() = assertJql(
        currentUser(),
        expectedJql = "currentUser()"
    )

    @Test
    fun `membersOf function`() = assertJql(
        membersOf("foo"),
        expectedJql = """membersOf("foo")"""
    )

    @Test
    fun `organizationMembers requires at least one argument`() {
        assertThrows<IllegalArgumentException> { organizationMembers() }
    }

    @Test
    fun `organizationMembers with string arguments`() = assertJql(
        organizationMembers("foo", "bar"),
        expectedJql = """organizationMembers("foo","bar")"""
    )

    @Test
    fun `organizationMembers with string collection argument`() = assertJql(
        organizationMembers(listOf("foo", "bar")),
        expectedJql = """organizationMembers("foo","bar")"""
    )
}
