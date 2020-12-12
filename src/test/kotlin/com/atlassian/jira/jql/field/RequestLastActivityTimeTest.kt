package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.endOfWeek
import com.atlassian.jira.jql.function.startOfMonth
import com.atlassian.jira.jql.function.startOfWeek
import com.atlassian.jira.jql.function.startOfYear
import com.atlassian.jira.jql.time.d
import com.atlassian.jira.jql.time.days
import com.atlassian.jira.jql.time.h
import com.atlassian.jira.jql.time.m
import com.atlassian.jira.jql.time.w
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class RequestLastActivityTimeTest {
    @Test
    fun `resolve by name`() {
        assertEquals(RequestLastActivityTime, Field.forName("request-last-activity-time"))
    }

    @Test
    fun `request last activity time greater than timestamp`() = assertJql(
        RequestLastActivityTime greaterThan LocalDateTime.of(2020, 9, 9, 13, 6),
        // language=JQL
        expectedJql = """request-last-activity-time > "2020-09-09 13:06""""
    )

    @Test
    fun `request last activity time greater than relative time`() = assertJql(
        RequestLastActivityTime greaterThan 2.d.ago,
        // language=JQL
        expectedJql = """request-last-activity-time > "-2d""""
    )

    @Test
    fun `request last activity time greater than function`() = assertJql(
        RequestLastActivityTime greaterThan startOfWeek(),
        // language=JQL
        expectedJql = """request-last-activity-time > startOfWeek()"""
    )

    @Test
    fun `request last activity time greater than equals timestamp`() = assertJql(
        RequestLastActivityTime greaterThanOrEqualTo LocalDateTime.of(2020, 9, 9, 13, 7),
        // language=JQL
        expectedJql = """request-last-activity-time >= "2020-09-09 13:07""""
    )

    @Test
    fun `request last activity time greater than equals relative time`() = assertJql(
        RequestLastActivityTime greaterThanOrEqualTo 5.w.ago,
        // language=JQL
        expectedJql = """request-last-activity-time >= "-5w""""
    )

    @Test
    fun `request last activity time greater than equals function`() = assertJql(
        RequestLastActivityTime greaterThanOrEqualTo startOfMonth(),
        // language=JQL
        expectedJql = """request-last-activity-time >= startOfMonth()"""
    )

    @Test
    fun `request last activity time less than timestamp`() = assertJql(
        RequestLastActivityTime lessThan LocalDateTime.of(2020, 8, 24, 1, 38),
        // language=JQL
        expectedJql = """request-last-activity-time < "2020-08-24 01:38""""
    )

    @Test
    fun `request last activity time less than relative time`() = assertJql(
        RequestLastActivityTime lessThan (2.d + 10.h).ago,
        // language=JQL
        expectedJql = """request-last-activity-time < "-2d 10h""""
    )

    @Test
    fun `request last activity time less than function`() = assertJql(
        RequestLastActivityTime lessThan startOfYear(),
        // language=JQL
        expectedJql = """request-last-activity-time < startOfYear()"""
    )

    @Test
    fun `request last activity time less than equals timestamp`() = assertJql(
        RequestLastActivityTime lessThanOrEqualTo LocalDateTime.of(2020, 8, 24, 1, 39),
        // language=JQL
        expectedJql = """request-last-activity-time <= "2020-08-24 01:39""""
    )

    @Test
    fun `request last activity time less than equals relative time`() = assertJql(
        RequestLastActivityTime lessThanOrEqualTo 15.m.ago,
        // language=JQL
        expectedJql = """request-last-activity-time <= "-15m""""
    )

    @Test
    fun `request last activity time less than equals function`() = assertJql(
        RequestLastActivityTime lessThanOrEqualTo endOfWeek(10.days.ago),
        // language=JQL
        expectedJql = """request-last-activity-time <= endOfWeek("-10d")"""
    )

    @Test
    fun `request last activity time is empty`() = assertJql(
        RequestLastActivityTime iz Empty,
        // language=JQL
        expectedJql = """request-last-activity-time is empty"""
    )

    @Test
    fun `request last activity time is null`() = assertJql(
        RequestLastActivityTime iz Null,
        // language=JQL
        expectedJql = """request-last-activity-time is null"""
    )

    @Test
    fun `request last activity time is not empty`() = assertJql(
        RequestLastActivityTime izNot Empty,
        // language=JQL
        expectedJql = """request-last-activity-time is not empty"""
    )

    @Test
    fun `request last activity time is not null`() = assertJql(
        RequestLastActivityTime izNot Null,
        // language=JQL
        expectedJql = """request-last-activity-time is not null"""
    )
}
