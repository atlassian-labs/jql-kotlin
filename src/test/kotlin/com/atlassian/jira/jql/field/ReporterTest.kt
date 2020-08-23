package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class ReporterTest {
    @Test
    fun `reporter equals to value`() = assertJql(
        Reporter equalTo "Jill Jones",
        // language=JQL
        expectedJql = """reporter = "Jill Jones""""
    )

    @Test
    fun `reporter not equals to value`() = assertJql(
        Reporter notEqualTo "bob@mycompany.com",
        // language=JQL
        expectedJql = """reporter != "bob@mycompany.com""""
    )

    @Test
    fun `reporter in values`() = assertJql(
        Reporter anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """reporter in ("foo","bar","baz")"""
    )

    @Test
    fun `reporter not in values`() = assertJql(
        Reporter noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """reporter not in ("abra","cadabra")"""
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
