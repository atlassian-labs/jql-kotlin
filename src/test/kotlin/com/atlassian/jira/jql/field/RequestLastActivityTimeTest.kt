package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.Jsd.RequestLastActivityTime
import com.atlassian.jira.jql.time.d
import com.atlassian.jira.jql.time.h
import com.atlassian.jira.jql.time.m
import com.atlassian.jira.jql.time.w
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class RequestLastActivityTimeTest {
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
