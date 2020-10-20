package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.endOfWeek
import com.atlassian.jira.jql.function.now
import com.atlassian.jira.jql.function.startOfMonth
import com.atlassian.jira.jql.function.startOfWeek
import com.atlassian.jira.jql.function.startOfYear
import com.atlassian.jira.jql.time.d
import com.atlassian.jira.jql.time.days
import com.atlassian.jira.jql.time.h
import com.atlassian.jira.jql.time.m
import com.atlassian.jira.jql.time.w
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DueTest {
    @Test
    fun `due equals to timestamp`() = assertJql(
        Due equalTo LocalDate.of(2020, 10, 20),
        // language=JQL
        expectedJql = """due = "2020-10-20""""
    )

    @Test
    fun `due equals to relative date`() = assertJql(
        Due equalTo 3.h.ago,
        // language=JQL
        expectedJql = """due = "-3h""""
    )

    @Test
    fun `due equals to function`() = assertJql(
        Due equalTo now(),
        // language=JQL
        expectedJql = """due = now()"""
    )

    @Test
    fun `due not equals to timestamp`() = assertJql(
        Due notEqualTo LocalDate.of(2020, 10, 19),
        // language=JQL
        expectedJql = """due != "2020-10-19""""
    )

    @Test
    fun `due not equals to relative date`() = assertJql(
        Due notEqualTo 3.h.fromNow,
        // language=JQL
        expectedJql = """due != "3h""""
    )

    @Test
    fun `due not equals to function`() = assertJql(
        Due notEqualTo startOfWeek(5.d.fromNow),
        // language=JQL
        expectedJql = """due != startOfWeek("5d")"""
    )

    @Test
    fun `due in timestamps`() = assertJql(
        Due anyOf listOf(LocalDate.of(2020, 10, 19), LocalDate.of(2020, 10, 20)),
        // language=JQL
        expectedJql = """due in ("2020-10-19","2020-10-20")"""
    )

    @Test
    fun `due not in timestamps`() = assertJql(
        Due noneOf listOf(LocalDate.of(2020, 8, 23), LocalDate.of(2020, 8, 24)),
        // language=JQL
        expectedJql = """due not in ("2020-08-23","2020-08-24")"""
    )

    @Test
    fun `due greater than timestamp`() = assertJql(
        Due greaterThan LocalDate.of(2020, 8, 24),
        // language=JQL
        expectedJql = """due > "2020-08-24""""
    )

    @Test
    fun `due greater than relative date`() = assertJql(
        Due greaterThan 3.w.fromNow,
        // language=JQL
        expectedJql = """due > "3w""""
    )

    @Test
    fun `due greater than function`() = assertJql(
        Due greaterThan startOfWeek(),
        // language=JQL
        expectedJql = """due > startOfWeek()"""
    )

    @Test
    fun `due greater than equals timestamp`() = assertJql(
        Due greaterThanOrEqualTo LocalDate.of(2020, 8, 24),
        // language=JQL
        expectedJql = """due >= "2020-08-24""""
    )

    @Test
    fun `due greater than equals relative date`() = assertJql(
        Due greaterThanOrEqualTo (2.d + 2.m).fromNow,
        // language=JQL
        expectedJql = """due >= "2d 2m""""
    )

    @Test
    fun `due greater than equals function`() = assertJql(
        Due greaterThanOrEqualTo startOfMonth(),
        // language=JQL
        expectedJql = """due >= startOfMonth()"""
    )

    @Test
    fun `due less than timestamp`() = assertJql(
        Due lessThan LocalDate.of(2020, 8, 24),
        // language=JQL
        expectedJql = """due < "2020-08-24""""
    )

    @Test
    fun `due less than relative date`() = assertJql(
        Due lessThan (1.w + 10.d).fromNow,
        // language=JQL
        expectedJql = """due < "1w 10d""""
    )

    @Test
    fun `due less than function`() = assertJql(
        Due lessThan startOfYear(),
        // language=JQL
        expectedJql = """due < startOfYear()"""
    )

    @Test
    fun `due less than equals timestamp`() = assertJql(
        Due lessThanOrEqualTo LocalDate.of(2020, 8, 24),
        // language=JQL
        expectedJql = """due <= "2020-08-24""""
    )

    @Test
    fun `due less than equals relative date`() = assertJql(
        Due lessThanOrEqualTo 3.w.fromNow,
        // language=JQL
        expectedJql = """due <= "3w""""
    )

    @Test
    fun `due less than equals function`() = assertJql(
        Due lessThanOrEqualTo endOfWeek(10.days.ago),
        // language=JQL
        expectedJql = """due <= endOfWeek("-10d")"""
    )

    @Test
    fun `due is empty`() = assertJql(
        Due iz Empty,
        // language=JQL
        expectedJql = """due is empty"""
    )

    @Test
    fun `due is null`() = assertJql(
        Due iz Null,
        // language=JQL
        expectedJql = """due is null"""
    )

    @Test
    fun `due is not empty`() = assertJql(
        Due izNot Empty,
        // language=JQL
        expectedJql = """due is not empty"""
    )

    @Test
    fun `due is not null`() = assertJql(
        Due izNot Null,
        // language=JQL
        expectedJql = """due is not null"""
    )
}
