package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.time.hours
import com.atlassian.jira.jql.time.minutes
import com.atlassian.jira.jql.time.weeks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OriginalEstimateTest {
    @Test
    fun `resolve by name`() {
        assertEquals(OriginalEstimate, Field.forName("originalEstimate"))
    }

    @Test
    fun `resolve by alias`() {
        assertEquals(OriginalEstimate, Field.forName("timeOriginalEstimate"))
    }

    @Test
    fun `original estimate equals to value`() = assertJql(
        OriginalEstimate equalTo 1.hours,
        // language=JQL
        expectedJql = """originalEstimate = "1h""""
    )

    @Test
    fun `original estimate not equals to value`() = assertJql(
        OriginalEstimate notEqualTo 10.minutes,
        // language=JQL
        expectedJql = """originalEstimate != "10m""""
    )

    @Test
    fun `original estimate in values`() = assertJql(
        OriginalEstimate anyOf listOf(1.weeks, 2.weeks),
        // language=JQL
        expectedJql = """originalEstimate in ("1w","2w")"""
    )

    @Test
    fun `original estimate not in values`() = assertJql(
        OriginalEstimate noneOf listOf(1.minutes, 5.minutes),
        // language=JQL
        expectedJql = """originalEstimate not in ("1m","5m")"""
    )

    @Test
    fun `original estimate greater than value`() = assertJql(
        OriginalEstimate greaterThan 2.hours,
        // language=JQL
        expectedJql = """originalEstimate > "2h""""
    )

    @Test
    fun `original estimate greater than equals value`() = assertJql(
        OriginalEstimate greaterThanOrEqualTo 17.minutes,
        // language=JQL
        expectedJql = """originalEstimate >= "17m""""
    )

    @Test
    fun `original estimate less than value`() = assertJql(
        OriginalEstimate lessThan 1.weeks,
        // language=JQL
        expectedJql = """originalEstimate < "1w""""
    )

    @Test
    fun `original estimate less than equals value`() = assertJql(
        OriginalEstimate lessThanOrEqualTo 3.hours,
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
