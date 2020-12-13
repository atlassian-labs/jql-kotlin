package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.currentUser
import com.atlassian.jira.jql.function.membersOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReporterTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Reporter, Field.forName("reporter"))
        assertEquals(Reporter, SortableField.forName("reporter"))
    }

    @Test
    fun `reporter equals to value`() = assertJql(
        Reporter equalTo "Jill Jones",
        // language=JQL
        expectedJql = """reporter = "Jill Jones""""
    )

    @Test
    fun `reporter equals to function`() = assertJql(
        Reporter equalTo currentUser(),
        // language=JQL
        expectedJql = """reporter = currentUser()"""
    )

    @Test
    fun `reporter not equals to value`() = assertJql(
        Reporter notEqualTo "bob@mycompany.com",
        // language=JQL
        expectedJql = """reporter != "bob@mycompany.com""""
    )

    @Test
    fun `reporter not equals to function`() = assertJql(
        Reporter notEqualTo currentUser(),
        // language=JQL
        expectedJql = """reporter != currentUser()"""
    )

    @Test
    fun `reporter in values`() = assertJql(
        Reporter anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """reporter in ("foo","bar","baz")"""
    )

    @Test
    fun `reporter in function`() = assertJql(
        Reporter anyOf membersOf("admins"),
        // language=JQL
        expectedJql = """reporter in membersOf("admins")"""
    )

    @Test
    fun `reporter not in values`() = assertJql(
        Reporter noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """reporter not in ("abra","cadabra")"""
    )

    @Test
    fun `reporter not in function`() = assertJql(
        Reporter noneOf membersOf("users"),
        // language=JQL
        expectedJql = """reporter not in membersOf("users")"""
    )

    @Test
    fun `reporter is empty`() = assertJql(
        Reporter iz Empty,
        // language=JQL
        expectedJql = """reporter is empty"""
    )

    @Test
    fun `reporter is null`() = assertJql(
        Reporter iz Null,
        // language=JQL
        expectedJql = """reporter is null"""
    )

    @Test
    fun `reporter is not empty`() = assertJql(
        Reporter izNot Empty,
        // language=JQL
        expectedJql = """reporter is not empty"""
    )

    @Test
    fun `reporter is not null`() = assertJql(
        Reporter izNot Null,
        // language=JQL
        expectedJql = """reporter is not null"""
    )
}
