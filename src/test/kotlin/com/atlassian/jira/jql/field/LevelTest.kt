package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LevelTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Level, Field.forName("level"))
    }

    @Test
    fun `level equals to string`() = assertJql(
        Level equalTo "Really High",
        // language=JQL
        expectedJql = """level = "Really High""""
    )

    @Test
    fun `level equals to number`() = assertJql(
        Level equalTo 123,
        // language=JQL
        expectedJql = """level = 123"""
    )

    @Test
    fun `level not equals to string`() = assertJql(
        Level notEqualTo "level1",
        // language=JQL
        expectedJql = """level != "level1""""
    )

    @Test
    fun `level not equals to number`() = assertJql(
        Level notEqualTo 123,
        // language=JQL
        expectedJql = """level != 123"""
    )

    @Test
    fun `level in strings`() = assertJql(
        Level anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """level in ("foo","bar","baz")"""
    )

    @Test
    fun `level in numbers`() = assertJql(
        Level anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """level in (1,2,3)"""
    )

    @Test
    fun `level not in strings`() = assertJql(
        Level noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """level not in ("abra","cadabra")"""
    )

    @Test
    fun `level not in numbers`() = assertJql(
        Level noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """level not in (4,5,6)"""
    )

    @Test
    fun `level is empty`() = assertJql(
        Level iz Empty,
        // language=JQL
        expectedJql = """level is empty"""
    )

    @Test
    fun `level is null`() = assertJql(
        Level iz Null,
        // language=JQL
        expectedJql = """level is null"""
    )

    @Test
    fun `level is not empty`() = assertJql(
        Level izNot Empty,
        // language=JQL
        expectedJql = """level is not empty"""
    )

    @Test
    fun `level is not null`() = assertJql(
        Level izNot Null,
        // language=JQL
        expectedJql = """level is not null"""
    )
}
