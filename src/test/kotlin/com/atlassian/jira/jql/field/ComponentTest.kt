package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class ComponentTest {
    @Test
    fun `component equals to string`() = assertJql(
        Component equalTo "Comp1",
        // language=JQL
        expectedJql = """component = "Comp1""""
    )

    @Test
    fun `component equals to number`() = assertJql(
        Component equalTo 20500,
        // language=JQL
        expectedJql = """component = 20500"""
    )

    @Test
    fun `component not equals to string`() = assertJql(
        Component notEqualTo "Comp2",
        // language=JQL
        expectedJql = """component != "Comp2""""
    )

    @Test
    fun `component not equals to number`() = assertJql(
        Component notEqualTo 123,
        // language=JQL
        expectedJql = """component != 123"""
    )

    @Test
    fun `component in strings`() = assertJql(
        Component anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """component in ("foo","bar","baz")"""
    )

    @Test
    fun `component in numbers`() = assertJql(
        Component anyOf numbers(1, 2, 3),
        // language=JQL
        expectedJql = """component in (1,2,3)"""
    )

    @Test
    fun `component not in strings`() = assertJql(
        Component noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """component not in ("abra","cadabra")"""
    )

    @Test
    fun `component not in numbers`() = assertJql(
        Component noneOf numbers(4, 5, 6),
        // language=JQL
        expectedJql = """component not in (4,5,6)"""
    )

    @Test
    fun `component is empty`() = assertJql(
        Component iz Empty,
        // language=JQL
        expectedJql = """component is empty"""
    )

    @Test
    fun `component is null`() = assertJql(
        Component iz Null,
        // language=JQL
        expectedJql = """component is null"""
    )

    @Test
    fun `component is not empty`() = assertJql(
        Component izNot Empty,
        // language=JQL
        expectedJql = """component is not empty"""
    )

    @Test
    fun `component is not null`() = assertJql(
        Component izNot Null,
        // language=JQL
        expectedJql = """component is not null"""
    )
}
