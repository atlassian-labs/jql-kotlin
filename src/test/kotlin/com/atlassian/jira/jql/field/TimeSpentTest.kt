package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.time.hours
import com.atlassian.jira.jql.time.minutes
import com.atlassian.jira.jql.time.weeks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TimeSpentTest {
    @Test
    fun `resolve by name`() {
        assertEquals(TimeSpent, Field.forName("timeSpent"))
        assertEquals(TimeSpent, SortableField.forName("timeSpent"))
    }

    @Test
    fun `time spent equals to value`() = assertJql(
        TimeSpent equalTo 1.hours,
        // language=JQL
        expectedJql = """timeSpent = "1h""""
    )

    @Test
    fun `time spent not equals to value`() = assertJql(
        TimeSpent notEqualTo 10.minutes,
        // language=JQL
        expectedJql = """timeSpent != "10m""""
    )

    @Test
    fun `time spent in values`() = assertJql(
        TimeSpent anyOf listOf(1.weeks, 2.weeks),
        // language=JQL
        expectedJql = """timeSpent in ("1w","2w")"""
    )

    @Test
    fun `time spent not in values`() = assertJql(
        TimeSpent noneOf listOf(1.minutes, 5.minutes),
        // language=JQL
        expectedJql = """timeSpent not in ("1m","5m")"""
    )

    @Test
    fun `time spent greater than value`() = assertJql(
        TimeSpent greaterThan 2.hours,
        // language=JQL
        expectedJql = """timeSpent > "2h""""
    )

    @Test
    fun `time spent greater than equals value`() = assertJql(
        TimeSpent greaterThanOrEqualTo 17.minutes,
        // language=JQL
        expectedJql = """timeSpent >= "17m""""
    )

    @Test
    fun `time spent less than value`() = assertJql(
        TimeSpent lessThan 1.weeks,
        // language=JQL
        expectedJql = """timeSpent < "1w""""
    )

    @Test
    fun `time spent less than equals value`() = assertJql(
        TimeSpent lessThanOrEqualTo 3.hours,
        // language=JQL
        expectedJql = """timeSpent <= "3h""""
    )

    @Test
    fun `time spent is empty`() = assertJql(
        TimeSpent iz Empty,
        // language=JQL
        expectedJql = """timeSpent is empty"""
    )

    @Test
    fun `time spent is null`() = assertJql(
        TimeSpent iz Null,
        // language=JQL
        expectedJql = """timeSpent is null"""
    )

    @Test
    fun `time spent is not empty`() = assertJql(
        TimeSpent izNot Empty,
        // language=JQL
        expectedJql = """timeSpent is not empty"""
    )

    @Test
    fun `time spent is not null`() = assertJql(
        TimeSpent izNot Null,
        // language=JQL
        expectedJql = """timeSpent is not null"""
    )
}
