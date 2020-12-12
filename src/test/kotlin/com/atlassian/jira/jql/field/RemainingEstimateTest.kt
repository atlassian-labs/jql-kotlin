package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.time.hours
import com.atlassian.jira.jql.time.minutes
import com.atlassian.jira.jql.time.weeks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RemainingEstimateTest {
    @Test
    fun `resolve by name`() {
        assertEquals(RemainingEstimate, Field.forName("remainingEstimate"))
    }

    @Test
    fun `resolve by alias`() {
        assertEquals(RemainingEstimate, Field.forName("timeEstimate"))
    }

    @Test
    fun `remaining estimate equals to value`() = assertJql(
        RemainingEstimate equalTo 1.hours,
        // language=JQL
        expectedJql = """remainingEstimate = "1h""""
    )

    @Test
    fun `remaining estimate not equals to value`() = assertJql(
        RemainingEstimate notEqualTo 10.minutes,
        // language=JQL
        expectedJql = """remainingEstimate != "10m""""
    )

    @Test
    fun `remaining estimate in values`() = assertJql(
        RemainingEstimate anyOf listOf(1.weeks, 2.weeks),
        // language=JQL
        expectedJql = """remainingEstimate in ("1w","2w")"""
    )

    @Test
    fun `remaining estimate not in values`() = assertJql(
        RemainingEstimate noneOf listOf(1.minutes, 5.minutes),
        // language=JQL
        expectedJql = """remainingEstimate not in ("1m","5m")"""
    )

    @Test
    fun `remaining estimate greater than value`() = assertJql(
        RemainingEstimate greaterThan 2.hours,
        // language=JQL
        expectedJql = """remainingEstimate > "2h""""
    )

    @Test
    fun `remaining estimate greater than equals value`() = assertJql(
        RemainingEstimate greaterThanOrEqualTo 17.minutes,
        // language=JQL
        expectedJql = """remainingEstimate >= "17m""""
    )

    @Test
    fun `remaining estimate less than value`() = assertJql(
        RemainingEstimate lessThan 1.weeks,
        // language=JQL
        expectedJql = """remainingEstimate < "1w""""
    )

    @Test
    fun `remaining estimate less than equals value`() = assertJql(
        RemainingEstimate lessThanOrEqualTo 3.hours,
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
