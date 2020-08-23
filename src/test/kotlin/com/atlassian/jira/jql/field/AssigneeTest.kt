package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class AssigneeTest {
    @Test
    fun `assignee equals to value`() = assertJql(
        Assignee equalTo "John Smith",
        // language=JQL
        expectedJql = """assignee = "John Smith""""
    )

    @Test
    fun `assignee not equals to value`() = assertJql(
        Assignee notEqualTo "bob@mycompany.com",
        // language=JQL
        expectedJql = """assignee != "bob@mycompany.com""""
    )

    @Test
    fun `assignee in values`() = assertJql(
        Assignee anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """assignee in ("foo","bar","baz")"""
    )

    @Test
    fun `assignee not in values`() = assertJql(
        Assignee noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """assignee not in ("abra","cadabra")"""
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
