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

class CreatedTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Created, Field.forName("created"))
        assertEquals(Created, SortableField.forName("created"))
    }

    @Test
    fun `resolve by alias`() {
        assertEquals(Created, Field.forName("createdDate"))
        assertEquals(Created, SortableField.forName("createdDate"))
    }

    @Test
    fun `created greater than timestamp`() = assertJql(
        Created greaterThan LocalDateTime.of(2020, 8, 24, 1, 20),
        // language=JQL
        expectedJql = """created > "2020-08-24 01:20""""
    )

    @Test
    fun `created greater than relative time`() = assertJql(
        Created greaterThan 3.w.ago,
        // language=JQL
        expectedJql = """created > "-3w""""
    )

    @Test
    fun `created greater than function`() = assertJql(
        Created greaterThan startOfWeek(),
        // language=JQL
        expectedJql = """created > startOfWeek()"""
    )

    @Test
    fun `created greater than equals timestamp`() = assertJql(
        Created greaterThanOrEqualTo LocalDateTime.of(2020, 8, 24, 1, 37),
        // language=JQL
        expectedJql = """created >= "2020-08-24 01:37""""
    )

    @Test
    fun `created greater than equals relative time`() = assertJql(
        Created greaterThanOrEqualTo (2.d + 5.m).ago,
        // language=JQL
        expectedJql = """created >= "-2d 5m""""
    )

    @Test
    fun `created greater than equals function`() = assertJql(
        Created greaterThanOrEqualTo startOfMonth(),
        // language=JQL
        expectedJql = """created >= startOfMonth()"""
    )

    @Test
    fun `created less than timestamp`() = assertJql(
        Created lessThan LocalDateTime.of(2020, 8, 24, 1, 38),
        // language=JQL
        expectedJql = """created < "2020-08-24 01:38""""
    )

    @Test
    fun `created less than relative time`() = assertJql(
        Created lessThan 1.w.ago,
        // language=JQL
        expectedJql = """created < "-1w""""
    )

    @Test
    fun `created less than function`() = assertJql(
        Created lessThan startOfYear(),
        // language=JQL
        expectedJql = """created < startOfYear()"""
    )

    @Test
    fun `created less than equals timestamp`() = assertJql(
        Created lessThanOrEqualTo LocalDateTime.of(2020, 8, 24, 1, 39),
        // language=JQL
        expectedJql = """created <= "2020-08-24 01:39""""
    )

    @Test
    fun `created less than equals relative time`() = assertJql(
        Created lessThanOrEqualTo (2.h + 10.m).ago,
        // language=JQL
        expectedJql = """created <= "-2h 10m""""
    )

    @Test
    fun `created less than equals function`() = assertJql(
        Created lessThanOrEqualTo endOfWeek(10.days.ago),
        // language=JQL
        expectedJql = """created <= endOfWeek("-10d")"""
    )

    @Test
    fun `created is empty`() = assertJql(
        Created iz Empty,
        // language=JQL
        expectedJql = """created is empty"""
    )

    @Test
    fun `created is null`() = assertJql(
        Created iz Null,
        // language=JQL
        expectedJql = """created is null"""
    )

    @Test
    fun `created is not empty`() = assertJql(
        Created izNot Empty,
        // language=JQL
        expectedJql = """created is not empty"""
    )

    @Test
    fun `created is not null`() = assertJql(
        Created izNot Null,
        // language=JQL
        expectedJql = """created is not null"""
    )
}
