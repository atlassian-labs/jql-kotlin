package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.projectsLeadByUser
import com.atlassian.jira.jql.function.projectsWhereUserHasRole
import org.junit.jupiter.api.Test

internal class ProjectTest {
    @Test
    fun `project equals to string`() = assertJql(
        Project equalTo "ABC Project",
        // language=JQL
        expectedJql = """project = "ABC Project""""
    )

    @Test
    fun `project equals to number`() = assertJql(
        Project equalTo 10350,
        // language=JQL
        expectedJql = """project = 10350"""
    )

    @Test
    fun `project not equals to string`() = assertJql(
        Project notEqualTo "ABC",
        // language=JQL
        expectedJql = """project != "ABC""""
    )

    @Test
    fun `project not equals to number`() = assertJql(
        Project notEqualTo 123,
        // language=JQL
        expectedJql = """project != 123"""
    )

    @Test
    fun `project in strings`() = assertJql(
        Project anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """project in ("foo","bar","baz")"""
    )

    @Test
    fun `project in numbers`() = assertJql(
        Project anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """project in (1,2,3)"""
    )

    @Test
    fun `project in function`() = assertJql(
        Project anyOf projectsLeadByUser("John Smith"),
        // language=JQL
        expectedJql = """project in projectsLeadByUser("John Smith")"""
    )

    @Test
    fun `project not in strings`() = assertJql(
        Project noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """project not in ("abra","cadabra")"""
    )

    @Test
    fun `project not in numbers`() = assertJql(
        Project noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """project not in (4,5,6)"""
    )

    @Test
    fun `project not in function`() = assertJql(
        Project noneOf projectsWhereUserHasRole("Administrators"),
        // language=JQL
        expectedJql = """project not in projectsWhereUserHasRole("Administrators")"""
    )

    @Test
    fun `project is empty`() = assertJql(
        Project iz Empty,
        // language=JQL
        expectedJql = """project is empty"""
    )

    @Test
    fun `project is null`() = assertJql(
        Project iz Null,
        // language=JQL
        expectedJql = """project is null"""
    )

    @Test
    fun `project is not empty`() = assertJql(
        Project izNot Empty,
        // language=JQL
        expectedJql = """project is not empty"""
    )

    @Test
    fun `project is not null`() = assertJql(
        Project izNot Null,
        // language=JQL
        expectedJql = """project is not null"""
    )
}
