package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class VotesTest {
    @Test
    fun `votes equals to value`() = assertJql(
        Votes equalTo 10000,
        // language=JQL
        expectedJql = """votes = 10000"""
    )

    @Test
    fun `votes not equals to value`() = assertJql(
        Votes notEqualTo 5254,
        // language=JQL
        expectedJql = """votes != 5254"""
    )

    @Test
    fun `votes in values`() = assertJql(
        Votes anyOf numbers(1, 2, 3),
        // language=JQL
        expectedJql = """votes in (1,2,3)"""
    )

    @Test
    fun `votes not in values`() = assertJql(
        Votes noneOf numbers(4, 5, 6),
        // language=JQL
        expectedJql = """votes not in (4,5,6)"""
    )

    @Test
    fun `votes greater than value`() = assertJql(
        Votes greaterThan 987,
        // language=JQL
        expectedJql = """votes > 987"""
    )

    @Test
    fun `votes greater than equals value`() = assertJql(
        Votes greaterThanOrEqualTo 12,
        // language=JQL
        expectedJql = """votes >= 12"""
    )

    @Test
    fun `votes less than value`() = assertJql(
        Votes lessThan 543,
        // language=JQL
        expectedJql = """votes < 543"""
    )

    @Test
    fun `votes less than equals value`() = assertJql(
        Votes lessThanOrEqualTo 890,
        // language=JQL
        expectedJql = """votes <= 890"""
    )
}
