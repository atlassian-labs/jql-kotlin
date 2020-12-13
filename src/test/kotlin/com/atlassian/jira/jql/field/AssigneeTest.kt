package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.currentUser
import com.atlassian.jira.jql.function.membersOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AssigneeTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Assignee, Field.forName("assignee"))
        assertEquals(Assignee, SortableField.forName("assignee"))
    }

    @Test
    fun `assignee equals to value`() = assertJql(
        Assignee equalTo "John Smith",
        // language=JQL
        expectedJql = """assignee = "John Smith""""
    )

    @Test
    fun `assignee equals to function`() = assertJql(
        Assignee equalTo currentUser(),
        // language=JQL
        expectedJql = """assignee = currentUser()"""
    )

    @Test
    fun `assignee not equals to value`() = assertJql(
        Assignee notEqualTo "bob@mycompany.com",
        // language=JQL
        expectedJql = """assignee != "bob@mycompany.com""""
    )

    @Test
    fun `assignee not equals to function`() = assertJql(
        Assignee notEqualTo currentUser(),
        // language=JQL
        expectedJql = """assignee != currentUser()"""
    )

    @Test
    fun `assignee in values`() = assertJql(
        Assignee anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """assignee in ("foo","bar","baz")"""
    )

    @Test
    fun `assignee in function`() = assertJql(
        Assignee anyOf membersOf("admins"),
        // language=JQL
        expectedJql = """assignee in membersOf("admins")"""
    )

    @Test
    fun `assignee not in values`() = assertJql(
        Assignee noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """assignee not in ("abra","cadabra")"""
    )

    @Test
    fun `assignee not in function`() = assertJql(
        Assignee noneOf membersOf("users"),
        // language=JQL
        expectedJql = """assignee not in membersOf("users")"""
    )

    @Test
    fun `assignee is empty`() = assertJql(
        Assignee iz Empty,
        // language=JQL
        expectedJql = """assignee is empty"""
    )

    @Test
    fun `assignee is null`() = assertJql(
        Assignee iz Null,
        // language=JQL
        expectedJql = """assignee is null"""
    )

    @Test
    fun `assignee is not empty`() = assertJql(
        Assignee izNot Empty,
        // language=JQL
        expectedJql = """assignee is not empty"""
    )

    @Test
    fun `assignee is not null`() = assertJql(
        Assignee izNot Null,
        // language=JQL
        expectedJql = """assignee is not null"""
    )
}
