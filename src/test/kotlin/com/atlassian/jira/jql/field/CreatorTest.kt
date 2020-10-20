package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.currentUser
import com.atlassian.jira.jql.function.membersOf
import org.junit.jupiter.api.Test

class CreatorTest {
    @Test
    fun `creator equals to value`() = assertJql(
        Creator equalTo "Jill Jones",
        // language=JQL
        expectedJql = """creator = "Jill Jones""""
    )

    @Test
    fun `creator equals to function`() = assertJql(
        Creator equalTo currentUser(),
        // language=JQL
        expectedJql = """creator = currentUser()"""
    )

    @Test
    fun `creator not equals to value`() = assertJql(
        Creator notEqualTo "bob@mycompany.com",
        // language=JQL
        expectedJql = """creator != "bob@mycompany.com""""
    )

    @Test
    fun `creator not equals to function`() = assertJql(
        Creator notEqualTo currentUser(),
        // language=JQL
        expectedJql = """creator != currentUser()"""
    )

    @Test
    fun `creator in values`() = assertJql(
        Creator anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """creator in ("foo","bar","baz")"""
    )

    @Test
    fun `creator in function`() = assertJql(
        Creator anyOf membersOf("admins"),
        // language=JQL
        expectedJql = """creator in membersOf("admins")"""
    )

    @Test
    fun `creator not in values`() = assertJql(
        Creator noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """creator not in ("abra","cadabra")"""
    )

    @Test
    fun `creator not in function`() = assertJql(
        Creator noneOf membersOf("users"),
        // language=JQL
        expectedJql = """creator not in membersOf("users")"""
    )

    @Test
    fun `creator is empty`() = assertJql(
        Creator iz Empty,
        // language=JQL
        expectedJql = """creator is empty"""
    )

    @Test
    fun `creator is null`() = assertJql(
        Creator iz Null,
        // language=JQL
        expectedJql = """creator is null"""
    )

    @Test
    fun `creator is not empty`() = assertJql(
        Creator izNot Empty,
        // language=JQL
        expectedJql = """creator is not empty"""
    )

    @Test
    fun `creator is not null`() = assertJql(
        Creator izNot Null,
        // language=JQL
        expectedJql = """creator is not null"""
    )
}
