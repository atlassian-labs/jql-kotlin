package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TypeTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Type, Field.forName("type"))
    }

    @Test
    fun `resolve by alias`() {
        assertEquals(Type, Field.forName("issueType"))
    }

    @Test
    fun `type equals to string`() = assertJql(
        Type equalTo "Bug",
        // language=JQL
        expectedJql = """type = "Bug""""
    )

    @Test
    fun `type equals to number`() = assertJql(
        Type equalTo 2,
        // language=JQL
        expectedJql = """type = 2"""
    )

    @Test
    fun `type not equals to string`() = assertJql(
        Type notEqualTo "ABC",
        // language=JQL
        expectedJql = """type != "ABC""""
    )

    @Test
    fun `type not equals to number`() = assertJql(
        Type notEqualTo 123,
        // language=JQL
        expectedJql = """type != 123"""
    )

    @Test
    fun `type in strings`() = assertJql(
        Type anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """type in ("foo","bar","baz")"""
    )

    @Test
    fun `type in numbers`() = assertJql(
        Type anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """type in (1,2,3)"""
    )

    @Test
    fun `type not in strings`() = assertJql(
        Type noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """type not in ("abra","cadabra")"""
    )

    @Test
    fun `type not in numbers`() = assertJql(
        Type noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """type not in (4,5,6)"""
    )

    @Test
    fun `type is empty`() = assertJql(
        Type iz Empty,
        // language=JQL
        expectedJql = """type is empty"""
    )

    @Test
    fun `type is null`() = assertJql(
        Type iz Null,
        // language=JQL
        expectedJql = """type is null"""
    )

    @Test
    fun `type is not empty`() = assertJql(
        Type izNot Empty,
        // language=JQL
        expectedJql = """type is not empty"""
    )

    @Test
    fun `type is not null`() = assertJql(
        Type izNot Null,
        // language=JQL
        expectedJql = """type is not null"""
    )
}
