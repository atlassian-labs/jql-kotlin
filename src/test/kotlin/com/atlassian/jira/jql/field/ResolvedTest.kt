package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
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
    fun `resolved greater than equals timestamp`() = assertJql(
        Resolved greaterThanOrEqualTo LocalDateTime.of(2020, 9, 10, 17, 56),
        // language=JQL
        expectedJql = """resolved >= "2020-09-10 17:56""""
    )

    @Test
    fun `resolved less than timestamp`() = assertJql(
        Resolved lessThan LocalDateTime.of(2020, 9, 10, 17, 56),
        // language=JQL
        expectedJql = """resolved < "2020-09-10 17:56""""
    )

    @Test
    fun `resolved less than equals timestamp`() = assertJql(
        Resolved lessThanOrEqualTo LocalDateTime.of(2020, 9, 10, 17, 57),
        // language=JQL
        expectedJql = """resolved <= "2020-09-10 17:57""""
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
