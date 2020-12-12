package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StatusTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Status, Field.forName("status"))
    }

    @Test
    fun `status equals to string`() = assertJql(
        Status equalTo "Open",
        // language=JQL
        expectedJql = """status = "Open""""
    )

    @Test
    fun `status equals to number`() = assertJql(
        Status equalTo 1,
        // language=JQL
        expectedJql = """status = 1"""
    )

    @Test
    fun `status not equals to string`() = assertJql(
        Status notEqualTo "In Progress",
        // language=JQL
        expectedJql = """status != "In Progress""""
    )

    @Test
    fun `status not equals to number`() = assertJql(
        Status notEqualTo 123,
        // language=JQL
        expectedJql = """status != 123"""
    )

    @Test
    fun `status in strings`() = assertJql(
        Status anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """status in ("foo","bar","baz")"""
    )

    @Test
    fun `status in numbers`() = assertJql(
        Status anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """status in (1,2,3)"""
    )

    @Test
    fun `status not in strings`() = assertJql(
        Status noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """status not in ("abra","cadabra")"""
    )

    @Test
    fun `status not in numbers`() = assertJql(
        Status noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """status not in (4,5,6)"""
    )

    @Test
    fun `status is empty`() = assertJql(
        Status iz Empty,
        // language=JQL
        expectedJql = """status is empty"""
    )

    @Test
    fun `status is null`() = assertJql(
        Status iz Null,
        // language=JQL
        expectedJql = """status is null"""
    )

    @Test
    fun `status is not empty`() = assertJql(
        Status izNot Empty,
        // language=JQL
        expectedJql = """status is not empty"""
    )

    @Test
    fun `status is not null`() = assertJql(
        Status izNot Null,
        // language=JQL
        expectedJql = """status is not null"""
    )
}
