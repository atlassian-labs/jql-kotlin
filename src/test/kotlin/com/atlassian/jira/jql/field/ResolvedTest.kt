package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.time.d
import com.atlassian.jira.jql.time.h
import com.atlassian.jira.jql.time.m
import com.atlassian.jira.jql.time.w
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class ResolvedTest {
    @Test
    fun `resolved greater than timestamp`() = assertJql(
        Resolved greaterThan LocalDateTime.of(2020, 9, 10, 17, 55),
        // language=JQL
        expectedJql = """resolved > "2020-09-10 17:55""""
    )

    @Test
    fun `resolved greater than relative time`() = assertJql(
        Resolved greaterThan (3.w + 4.h).ago,
        // language=JQL
        expectedJql = """resolved > "-3w 4h""""
    )

    @Test
    fun `resolved greater than equals timestamp`() = assertJql(
        Resolved greaterThanOrEqualTo LocalDateTime.of(2020, 9, 10, 17, 56),
        // language=JQL
        expectedJql = """resolved >= "2020-09-10 17:56""""
    )

    @Test
    fun `resolved greater than equals relative time`() = assertJql(
        Resolved greaterThanOrEqualTo 13.m.ago,
        // language=JQL
        expectedJql = """resolved >= "-13m""""
    )

    @Test
    fun `resolved less than timestamp`() = assertJql(
        Resolved lessThan LocalDateTime.of(2020, 9, 10, 17, 56),
        // language=JQL
        expectedJql = """resolved < "2020-09-10 17:56""""
    )

    @Test
    fun `resolved less than relative time`() = assertJql(
        Resolved lessThan 2.d.ago,
        // language=JQL
        expectedJql = """resolved < "-2d""""
    )

    @Test
    fun `resolved less than equals timestamp`() = assertJql(
        Resolved lessThanOrEqualTo LocalDateTime.of(2020, 9, 10, 17, 57),
        // language=JQL
        expectedJql = """resolved <= "2020-09-10 17:57""""
    )

    @Test
    fun `resolved less than equals relative time`() = assertJql(
        Resolved lessThanOrEqualTo 3.w.ago,
        // language=JQL
        expectedJql = """resolved <= "-3w""""
    )

    @Test
    fun `resolved is empty`() = assertJql(
        Resolved iz Empty,
        // language=JQL
        expectedJql = """resolved is empty"""
    )

    @Test
    fun `resolved is null`() = assertJql(
        Resolved iz Null,
        // language=JQL
        expectedJql = """resolved is null"""
    )

    @Test
    fun `resolved is not empty`() = assertJql(
        Resolved izNot Empty,
        // language=JQL
        expectedJql = """resolved is not empty"""
    )

    @Test
    fun `resolved is not null`() = assertJql(
        Resolved izNot Null,
        // language=JQL
        expectedJql = """resolved is not null"""
    )
}
