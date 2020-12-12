package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResolutionTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Resolution, Field.forName("resolution"))
    }

    @Test
    fun `resolution equals to string`() = assertJql(
        Resolution equalTo "Cannot Reproduce",
        // language=JQL
        expectedJql = """resolution = "Cannot Reproduce""""
    )

    @Test
    fun `resolution equals to number`() = assertJql(
        Resolution equalTo 10350,
        // language=JQL
        expectedJql = """resolution = 10350"""
    )

    @Test
    fun `resolution not equals to string`() = assertJql(
        Resolution notEqualTo "Won't Fix",
        // language=JQL
        expectedJql = """resolution != "Won't Fix""""
    )

    @Test
    fun `resolution not equals to number`() = assertJql(
        Resolution notEqualTo 123,
        // language=JQL
        expectedJql = """resolution != 123"""
    )

    @Test
    fun `resolution in strings`() = assertJql(
        Resolution anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """resolution in ("foo","bar","baz")"""
    )

    @Test
    fun `resolution in numbers`() = assertJql(
        Resolution anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """resolution in (1,2,3)"""
    )

    @Test
    fun `resolution not in strings`() = assertJql(
        Resolution noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """resolution not in ("abra","cadabra")"""
    )

    @Test
    fun `resolution not in numbers`() = assertJql(
        Resolution noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """resolution not in (4,5,6)"""
    )

    @Test
    fun `resolution greater than string`() = assertJql(
        Resolution greaterThan "3.14",
        // language=JQL
        expectedJql = """resolution > "3.14""""
    )

    @Test
    fun `resolution greater than number`() = assertJql(
        Resolution greaterThan 987,
        // language=JQL
        expectedJql = """resolution > 987"""
    )

    @Test
    fun `resolution greater than equals string`() = assertJql(
        Resolution greaterThanOrEqualTo "foo",
        // language=JQL
        expectedJql = """resolution >= "foo""""
    )

    @Test
    fun `resolution greater than equals number`() = assertJql(
        Resolution greaterThanOrEqualTo 567,
        // language=JQL
        expectedJql = """resolution >= 567"""
    )

    @Test
    fun `resolution less than string`() = assertJql(
        Resolution lessThan "2.72",
        // language=JQL
        expectedJql = """resolution < "2.72""""
    )

    @Test
    fun `resolution less than number`() = assertJql(
        Resolution lessThan 543,
        // language=JQL
        expectedJql = """resolution < 543"""
    )

    @Test
    fun `resolution less than equals string`() = assertJql(
        Resolution lessThanOrEqualTo "bar",
        // language=JQL
        expectedJql = """resolution <= "bar""""
    )

    @Test
    fun `resolution less than equals number`() = assertJql(
        Resolution lessThanOrEqualTo 890,
        // language=JQL
        expectedJql = """resolution <= 890"""
    )

    @Test
    fun `resolution is empty`() = assertJql(
        Resolution iz Empty,
        // language=JQL
        expectedJql = """resolution is empty"""
    )

    @Test
    fun `resolution is null`() = assertJql(
        Resolution iz Null,
        // language=JQL
        expectedJql = """resolution is null"""
    )

    @Test
    fun `resolution is not empty`() = assertJql(
        Resolution izNot Empty,
        // language=JQL
        expectedJql = """resolution is not empty"""
    )

    @Test
    fun `resolution is not null`() = assertJql(
        Resolution izNot Null,
        // language=JQL
        expectedJql = """resolution is not null"""
    )
}
