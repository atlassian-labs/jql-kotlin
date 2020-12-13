package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.endOfMonth
import com.atlassian.jira.jql.function.endOfWeek
import com.atlassian.jira.jql.function.startOfMonth
import com.atlassian.jira.jql.function.startOfWeek
import com.atlassian.jira.jql.time.d
import com.atlassian.jira.jql.time.h
import com.atlassian.jira.jql.time.m
import com.atlassian.jira.jql.time.w
import com.atlassian.jira.jql.time.weeks
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class LastViewedTest {
    @Test
    fun `resolve by name`() {
        assertEquals(LastViewed, Field.forName("lastViewed"))
        assertEquals(LastViewed, SortableField.forName("lastViewed"))
    }

    @Test
    fun `last viewed greater than timestamp`() = assertJql(
        LastViewed greaterThan LocalDateTime.of(2020, 8, 30, 23, 41),
        // language=JQL
        expectedJql = """lastViewed > "2020-08-30 23:41""""
    )

    @Test
    fun `last viewed greater than relative time`() = assertJql(
        LastViewed greaterThan (3.h + 15.m).ago,
        // language=JQL
        expectedJql = """lastViewed > "-3h 15m""""
    )

    @Test
    fun `last viewed greater than function`() = assertJql(
        LastViewed greaterThan startOfWeek(),
        // language=JQL
        expectedJql = """lastViewed > startOfWeek()"""
    )

    @Test
    fun `last viewed greater than equals timestamp`() = assertJql(
        LastViewed greaterThanOrEqualTo LocalDateTime.of(2020, 8, 30, 23, 46),
        // language=JQL
        expectedJql = """lastViewed >= "2020-08-30 23:46""""
    )

    @Test
    fun `last viewed greater than equals relative time`() = assertJql(
        LastViewed greaterThanOrEqualTo 1.w.ago,
        // language=JQL
        expectedJql = """lastViewed >= "-1w""""
    )

    @Test
    fun `last viewed greater than equals function`() = assertJql(
        LastViewed greaterThanOrEqualTo startOfMonth(),
        // language=JQL
        expectedJql = """lastViewed >= startOfMonth()"""
    )

    @Test
    fun `last viewed less than timestamp`() = assertJql(
        LastViewed lessThan LocalDateTime.of(2020, 8, 30, 23, 48),
        // language=JQL
        expectedJql = """lastViewed < "2020-08-30 23:48""""
    )

    @Test
    fun `last viewed less than relative time`() = assertJql(
        LastViewed lessThan 1.d.ago,
        // language=JQL
        expectedJql = """lastViewed < "-1d""""
    )

    @Test
    fun `last viewed less than function`() = assertJql(
        LastViewed lessThan endOfMonth(10.weeks.ago),
        // language=JQL
        expectedJql = """lastViewed < endOfMonth("-10w")"""
    )

    @Test
    fun `last viewed less than equals timestamp`() = assertJql(
        LastViewed lessThanOrEqualTo LocalDateTime.of(2020, 8, 30, 23, 42),
        // language=JQL
        expectedJql = """lastViewed <= "2020-08-30 23:42""""
    )

    @Test
    fun `last viewed less than equals relative time`() = assertJql(
        LastViewed lessThanOrEqualTo 1.w.ago,
        // language=JQL
        expectedJql = """lastViewed <= "-1w""""
    )

    @Test
    fun `last viewed less than equals function`() = assertJql(
        LastViewed lessThanOrEqualTo endOfWeek(72.d.ago),
        // language=JQL
        expectedJql = """lastViewed <= endOfWeek("-72d")"""
    )

    @Test
    fun `last viewed is empty`() = assertJql(
        LastViewed iz Empty,
        // language=JQL
        expectedJql = """lastViewed is empty"""
    )

    @Test
    fun `last viewed is null`() = assertJql(
        LastViewed iz Null,
        // language=JQL
        expectedJql = """lastViewed is null"""
    )

    @Test
    fun `last viewed is not empty`() = assertJql(
        LastViewed izNot Empty,
        // language=JQL
        expectedJql = """lastViewed is not empty"""
    )

    @Test
    fun `last viewed is not null`() = assertJql(
        LastViewed izNot Null,
        // language=JQL
        expectedJql = """lastViewed is not null"""
    )
}
