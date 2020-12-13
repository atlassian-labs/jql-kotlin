package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PriorityTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Priority, Field.forName("priority"))
        assertEquals(Priority, SortableField.forName("priority"))
    }

    @Test
    fun `priority equals to string`() = assertJql(
        Priority equalTo "High",
        // language=JQL
        expectedJql = """priority = "High""""
    )

    @Test
    fun `priority equals to number`() = assertJql(
        Priority equalTo 10000,
        // language=JQL
        expectedJql = """priority = 10000"""
    )

    @Test
    fun `priority not equals to string`() = assertJql(
        Priority notEqualTo "Not so high",
        // language=JQL
        expectedJql = """priority != "Not so high""""
    )

    @Test
    fun `priority not equals to number`() = assertJql(
        Priority notEqualTo 5254,
        // language=JQL
        expectedJql = """priority != 5254"""
    )

    @Test
    fun `priority in strings`() = assertJql(
        Priority anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """priority in ("foo","bar","baz")"""
    )

    @Test
    fun `priority in numbers`() = assertJql(
        Priority anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """priority in (1,2,3)"""
    )

    @Test
    fun `priority not in strings`() = assertJql(
        Priority noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """priority not in ("abra","cadabra")"""
    )

    @Test
    fun `priority not in numbers`() = assertJql(
        Priority noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """priority not in (4,5,6)"""
    )

    @Test
    fun `priority greater than string`() = assertJql(
        Priority greaterThan "3.14",
        // language=JQL
        expectedJql = """priority > "3.14""""
    )

    @Test
    fun `priority greater than number`() = assertJql(
        Priority greaterThan 987,
        // language=JQL
        expectedJql = """priority > 987"""
    )

    @Test
    fun `priority greater than equals string`() = assertJql(
        Priority greaterThanOrEqualTo "foo",
        // language=JQL
        expectedJql = """priority >= "foo""""
    )

    @Test
    fun `priority greater than equals number`() = assertJql(
        Priority greaterThanOrEqualTo 567,
        // language=JQL
        expectedJql = """priority >= 567"""
    )

    @Test
    fun `priority less than string`() = assertJql(
        Priority lessThan "2.72",
        // language=JQL
        expectedJql = """priority < "2.72""""
    )

    @Test
    fun `priority less than number`() = assertJql(
        Priority lessThan 543,
        // language=JQL
        expectedJql = """priority < 543"""
    )

    @Test
    fun `priority less than equals string`() = assertJql(
        Priority lessThanOrEqualTo "bar",
        // language=JQL
        expectedJql = """priority <= "bar""""
    )

    @Test
    fun `priority less than equals number`() = assertJql(
        Priority lessThanOrEqualTo 890,
        // language=JQL
        expectedJql = """priority <= 890"""
    )

    @Test
    fun `priority is empty`() = assertJql(
        Priority iz Empty,
        // language=JQL
        expectedJql = """priority is empty"""
    )

    @Test
    fun `priority is null`() = assertJql(
        Priority iz Null,
        // language=JQL
        expectedJql = """priority is null"""
    )

    @Test
    fun `priority is not empty`() = assertJql(
        Priority izNot Empty,
        // language=JQL
        expectedJql = """priority is not empty"""
    )

    @Test
    fun `priority is not null`() = assertJql(
        Priority izNot Null,
        // language=JQL
        expectedJql = """priority is not null"""
    )
}
