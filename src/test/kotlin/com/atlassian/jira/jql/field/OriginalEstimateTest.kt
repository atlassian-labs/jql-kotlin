package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.RelativeDateTime
import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class OriginalEstimateTest {
    @Test
    fun `original estimate equals to value`() = assertJql(
        OriginalEstimate equalTo RelativeDateTime(hours = 1),
        // language=JQL
        expectedJql = """originalEstimate = "1h""""
    )

    @Test
    fun `original estimate not equals to value`() = assertJql(
        OriginalEstimate notEqualTo RelativeDateTime(minutes = 10),
        // language=JQL
        expectedJql = """originalEstimate != "10m""""
    )

    @Test
    fun `original estimate in values`() = assertJql(
        OriginalEstimate anyOf listOf(RelativeDateTime(weeks = 1), RelativeDateTime(weeks = 2)),
        // language=JQL
        expectedJql = """originalEstimate in ("1w","2w")"""
    )

    @Test
    fun `original estimate not in values`() = assertJql(
        OriginalEstimate noneOf listOf(RelativeDateTime(minutes = 1), RelativeDateTime(minutes = 5)),
        // language=JQL
        expectedJql = """originalEstimate not in ("1m","5m")"""
    )

    @Test
    fun `original estimate greater than value`() = assertJql(
        OriginalEstimate greaterThan RelativeDateTime(hours = 2),
        // language=JQL
        expectedJql = """originalEstimate > "2h""""
    )

    @Test
    fun `original estimate greater than equals value`() = assertJql(
        OriginalEstimate greaterThanOrEqualTo RelativeDateTime(minutes = 17),
        // language=JQ6
        expectedJql = """originalEstimate >= "17m""""
    )

    @Test
    fun `original estimate less than value`() = assertJql(
        OriginalEstimate lessThan RelativeDateTime(weeks = 1),
        // language=JQL
        expectedJql = """originalEstimate < "1w""""
    )

    @Test
    fun `original estimate less than equals value`() = assertJql(
        OriginalEstimate lessThanOrEqualTo RelativeDateTime(hours = 3),
        // language=JQL
        expectedJql = """originalEstimate <= "3h""""
    )

    @Test
    fun `original estimate is empty`() = assertJql(
        OriginalEstimate iz Empty,
        // language=JQL
        expectedJql = """originalEstimate is empty"""
    )

    @Test
    fun `original estimate is null`() = assertJql(
        OriginalEstimate iz Null,
        // language=JQL
        expectedJql = """originalEstimate is null"""
    )

    @Test
    fun `original estimate is not empty`() = assertJql(
        OriginalEstimate izNot Empty,
        // language=JQL
        expectedJql = """originalEstimate is not empty"""
    )

    @Test
    fun `original estimate is not null`() = assertJql(
        OriginalEstimate izNot Null,
        // language=JQL
        expectedJql = """originalEstimate is not null"""
    )
}
