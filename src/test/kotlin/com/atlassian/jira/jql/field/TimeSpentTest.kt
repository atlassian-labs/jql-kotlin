package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.RelativeDateTime
import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class TimeSpentTest {
    @Test
    fun `time spent equals to value`() = assertJql(
        TimeSpent equalTo RelativeDateTime(hours = 1),
        // language=JQL
        expectedJql = """timeSpent = "1h""""
    )

    @Test
    fun `time spent not equals to value`() = assertJql(
        TimeSpent notEqualTo RelativeDateTime(minutes = 10),
        // language=JQL
        expectedJql = """timeSpent != "10m""""
    )

    @Test
    fun `time spent in values`() = assertJql(
        TimeSpent anyOf listOf(RelativeDateTime(weeks = 1), RelativeDateTime(weeks = 2)),
        // language=JQL
        expectedJql = """timeSpent in ("1w","2w")"""
    )

    @Test
    fun `time spent not in values`() = assertJql(
        TimeSpent noneOf listOf(RelativeDateTime(minutes = 1), RelativeDateTime(minutes = 5)),
        // language=JQL
        expectedJql = """timeSpent not in ("1m","5m")"""
    )

    @Test
    fun `time spent greater than value`() = assertJql(
        TimeSpent greaterThan RelativeDateTime(hours = 2),
        // language=JQL
        expectedJql = """timeSpent > "2h""""
    )

    @Test
    fun `time spent greater than equals value`() = assertJql(
        TimeSpent greaterThanOrEqualTo RelativeDateTime(minutes = 17),
        // language=JQ6
        expectedJql = """timeSpent >= "17m""""
    )

    @Test
    fun `time spent less than value`() = assertJql(
        TimeSpent lessThan RelativeDateTime(weeks = 1),
        // language=JQL
        expectedJql = """timeSpent < "1w""""
    )

    @Test
    fun `time spent less than equals value`() = assertJql(
        TimeSpent lessThanOrEqualTo RelativeDateTime(hours = 3),
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
