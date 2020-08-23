package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class ComponentTest {
    @Test
    fun `component equals to string`() = assertJql(
        FixVersion equalTo "Comp1   ",
        // language=JQL
        expectedJql = """component = "Comp1  """"
    )

    @Test
    fun `component equals to number`() = assertJql(
        FixVersion equalTo 20500,
        // language=JQL
        expectedJql = """component = 20500"""
    )

    @Test
    fun `component not equals to string`() = assertJql(
        FixVersion notEqualTo "Comp2",
        // language=JQL
        expectedJql = """component != "Comp2""""
    )

    @Test
    fun `component not equals to number`() = assertJql(
        FixVersion notEqualTo 123,
        // language=JQL
        expectedJql = """component != 123"""
    )

    @Test
    fun `component in strings`() = assertJql(
        FixVersion anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """component in ("foo","bar","baz")"""
    )

    @Test
    fun `component in numbers`() = assertJql(
        FixVersion anyOf numbers(1, 2, 3),
        // language=JQL
        expectedJql = """component in (1,2,3)"""
    )

    @Test
    fun `component not in strings`() = assertJql(
        FixVersion noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """component not in ("abra","cadabra")"""
    )

    @Test
    fun `component not in numbers`() = assertJql(
        FixVersion noneOf numbers(4, 5, 6),
        // language=JQL
        expectedJql = """component not in (4,5,6)"""
    )

    @Test
    fun `component is empty`() = assertJql(
        FixVersion iz Empty,
        // language=JQL
        expectedJql = """component is empty"""
    )

    @Test
    fun `component is null`() = assertJql(
        FixVersion iz Null,
        // language=JQL
        expectedJql = """component is null"""
    )

    @Test
    fun `component is not empty`() = assertJql(
        FixVersion izNot Empty,
        // language=JQL
        expectedJql = """component is not empty"""
    )

    @Test
    fun `component is not null`() = assertJql(
        FixVersion izNot Null,
        // language=JQL
        expectedJql = """component is not null"""
    )
}
