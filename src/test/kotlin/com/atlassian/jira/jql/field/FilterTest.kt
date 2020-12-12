package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FilterTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Filter, Field.forName("filter"))
    }

    @Test
    fun `resolve by alias`() {
        assertEquals(Filter, Field.forName("request"))
        assertEquals(Filter, Field.forName("savedFilter"))
        assertEquals(Filter, Field.forName("searchRequest"))
    }

    @Test
    fun `filter equals to string`() = assertJql(
        Filter equalTo "My Saved Filter",
        // language=JQL
        expectedJql = """filter = "My Saved Filter""""
    )

    @Test
    fun `filter equals to number`() = assertJql(
        Filter equalTo 12000,
        // language=JQL
        expectedJql = """filter = 12000"""
    )

    @Test
    fun `filter not equals to string`() = assertJql(
        Filter notEqualTo "Another filter",
        // language=JQL
        expectedJql = """filter != "Another filter""""
    )

    @Test
    fun `filter not equals to number`() = assertJql(
        Filter notEqualTo 123,
        // language=JQL
        expectedJql = """filter != 123"""
    )

    @Test
    fun `filter in strings`() = assertJql(
        Filter anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """filter in ("foo","bar","baz")"""
    )

    @Test
    fun `filter in numbers`() = assertJql(
        Filter anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """filter in (1,2,3)"""
    )

    @Test
    fun `filter not in strings`() = assertJql(
        Filter noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """filter not in ("abra","cadabra")"""
    )

    @Test
    fun `filter not in numbers`() = assertJql(
        Filter noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """filter not in (4,5,6)"""
    )
}
