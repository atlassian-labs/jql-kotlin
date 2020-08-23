package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class VoterTest {
    @Test
    fun `voter equals to value`() = assertJql(
        Voter equalTo "Jill Jones",
        // language=JQL
        expectedJql = """voter = "Jill Jones""""
    )

    @Test
    fun `voter not equals to value`() = assertJql(
        Voter notEqualTo "bob@mycompany.com",
        // language=JQL
        expectedJql = """voter != "bob@mycompany.com""""
    )

    @Test
    fun `voter in values`() = assertJql(
        Voter anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """voter in ("foo","bar","baz")"""
    )

    @Test
    fun `voter not in values`() = assertJql(
        Voter noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """voter not in ("abra","cadabra")"""
    )

    @Test
    fun `voter is empty`() = assertJql(
        Voter iz Empty,
        // language=JQL
        expectedJql = """voter is empty"""
    )

    @Test
    fun `voter is null`() = assertJql(
        Voter iz Null,
        // language=JQL
        expectedJql = """voter is null"""
    )

    @Test
    fun `voter is not empty`() = assertJql(
        Voter izNot Empty,
        // language=JQL
        expectedJql = """voter is not empty"""
    )

    @Test
    fun `voter is not null`() = assertJql(
        Voter izNot Null,
        // language=JQL
        expectedJql = """voter is not null"""
    )
}
