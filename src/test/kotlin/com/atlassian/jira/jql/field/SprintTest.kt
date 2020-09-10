package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class SprintTest {
    @Test
    fun `sprint equals to string`() = assertJql(
        Sprint equalTo "February 1",
        // language=JQL
        expectedJql = """sprint = "February 1""""
    )

    @Test
    fun `sprint equals to number`() = assertJql(
        Sprint equalTo 999,
        // language=JQL
        expectedJql = """sprint = 999"""
    )

    @Test
    fun `sprint not equals to string`() = assertJql(
        Sprint notEqualTo "ABC",
        // language=JQL
        expectedJql = """sprint != "ABC""""
    )

    @Test
    fun `sprint not equals to number`() = assertJql(
        Sprint notEqualTo 123,
        // language=JQL
        expectedJql = """sprint != 123"""
    )

    @Test
    fun `sprint in strings`() = assertJql(
        Sprint anyOf listOf("February 1", "February 2", "February 3"),
        // language=JQL
        expectedJql = """sprint in ("February 1","February 2","February 3")"""
    )

    @Test
    fun `sprint in numbers`() = assertJql(
        Sprint anyOf numbers(1, 2, 3),
        // language=JQL
        expectedJql = """sprint in (1,2,3)"""
    )

    @Test
    fun `sprint not in strings`() = assertJql(
        Sprint noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """sprint not in ("abra","cadabra")"""
    )

    @Test
    fun `sprint not in numbers`() = assertJql(
        Sprint noneOf numbers(4, 5, 6),
        // language=JQL
        expectedJql = """sprint not in (4,5,6)"""
    )

    @Test
    fun `sprint is empty`() = assertJql(
        Sprint iz Empty,
        // language=JQL
        expectedJql = """sprint is empty"""
    )

    @Test
    fun `sprint is null`() = assertJql(
        Sprint iz Null,
        // language=JQL
        expectedJql = """sprint is null"""
    )

    @Test
    fun `sprint is not empty`() = assertJql(
        Sprint izNot Empty,
        // language=JQL
        expectedJql = """sprint is not empty"""
    )

    @Test
    fun `sprint is not null`() = assertJql(
        Sprint izNot Null,
        // language=JQL
        expectedJql = """sprint is not null"""
    )
}
