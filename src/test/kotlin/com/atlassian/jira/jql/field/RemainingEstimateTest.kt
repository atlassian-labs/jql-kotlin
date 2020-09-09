package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.RelativeDateTime
import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class RemainingEstimateTest {
    @Test
    fun `remaining estimate equals to value`() = assertJql(
        RemainingEstimate equalTo RelativeDateTime(hours = 1),
        // language=JQL
        expectedJql = """remainingEstimate = "1h""""
    )

    @Test
    fun `remaining estimate not equals to value`() = assertJql(
        RemainingEstimate notEqualTo RelativeDateTime(minutes = 10),
        // language=JQL
        expectedJql = """remainingEstimate != "10m""""
    )

    @Test
    fun `remaining estimate in values`() = assertJql(
        RemainingEstimate anyOf listOf(RelativeDateTime(weeks = 1), RelativeDateTime(weeks = 2)),
        // language=JQL
        expectedJql = """remainingEstimate in ("1w","2w")"""
    )

    @Test
    fun `remaining estimate not in values`() = assertJql(
        RemainingEstimate noneOf listOf(RelativeDateTime(minutes = 1), RelativeDateTime(minutes = 5)),
        // language=JQL
        expectedJql = """remainingEstimate not in ("1m","5m")"""
    )

    @Test
    fun `remaining estimate greater than value`() = assertJql(
        RemainingEstimate greaterThan RelativeDateTime(hours = 2),
        // language=JQL
        expectedJql = """remainingEstimate > "2h""""
    )

    @Test
    fun `remaining estimate greater than equals value`() = assertJql(
        RemainingEstimate greaterThanOrEqualTo RelativeDateTime(minutes = 17),
        // language=JQ6
        expectedJql = """remainingEstimate >= "17m""""
    )

    @Test
    fun `remaining estimate less than value`() = assertJql(
        RemainingEstimate lessThan RelativeDateTime(weeks = 1),
        // language=JQL
        expectedJql = """remainingEstimate < "1w""""
    )

    @Test
    fun `remaining estimate less than equals value`() = assertJql(
        RemainingEstimate lessThanOrEqualTo RelativeDateTime(hours = 3),
        // language=JQL
        expectedJql = """remainingEstimate <= "3h""""
    )

    @Test
    fun `remaining estimate is empty`() = assertJql(
        RemainingEstimate iz Empty,
        // language=JQL
        expectedJql = """remainingEstimate is empty"""
    )

    @Test
    fun `remaining estimate is null`() = assertJql(
        RemainingEstimate iz Null,
        // language=JQL
        expectedJql = """remainingEstimate is null"""
    )

    @Test
    fun `remaining estimate is not empty`() = assertJql(
        RemainingEstimate izNot Empty,
        // language=JQL
        expectedJql = """remainingEstimate is not empty"""
    )

    @Test
    fun `remaining estimate is not null`() = assertJql(
        RemainingEstimate izNot Null,
        // language=JQL
        expectedJql = """remainingEstimate is not null"""
    )
}
