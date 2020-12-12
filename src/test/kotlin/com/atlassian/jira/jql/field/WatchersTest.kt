package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WatchersTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Watchers, Field.forName("watchers"))
    }

    @Test
    fun `watchers equals to value`() = assertJql(
        Watchers equalTo 10000,
        // language=JQL
        expectedJql = """watchers = 10000"""
    )

    @Test
    fun `watchers not equals to value`() = assertJql(
        Watchers notEqualTo 5254,
        // language=JQL
        expectedJql = """watchers != 5254"""
    )

    @Test
    fun `watchers in values`() = assertJql(
        Watchers anyOf listOf(1, 2, 3),
        // language=JQL
        expectedJql = """watchers in (1,2,3)"""
    )

    @Test
    fun `watchers not in values`() = assertJql(
        Watchers noneOf listOf(4, 5, 6),
        // language=JQL
        expectedJql = """watchers not in (4,5,6)"""
    )

    @Test
    fun `watchers greater than value`() = assertJql(
        Watchers greaterThan 987,
        // language=JQL
        expectedJql = """watchers > 987"""
    )

    @Test
    fun `watchers greater than equals value`() = assertJql(
        Watchers greaterThanOrEqualTo 12,
        // language=JQL
        expectedJql = """watchers >= 12"""
    )

    @Test
    fun `watchers less than value`() = assertJql(
        Watchers lessThan 543,
        // language=JQL
        expectedJql = """watchers < 543"""
    )

    @Test
    fun `watchers less than equals value`() = assertJql(
        Watchers lessThanOrEqualTo 890,
        // language=JQL
        expectedJql = """watchers <= 890"""
    )
}
