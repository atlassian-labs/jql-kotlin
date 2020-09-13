package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.time.d
import com.atlassian.jira.jql.time.w
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DueTest {
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
    fun `due greater than equals timestamp`() = assertJql(
        Due greaterThanOrEqualTo LocalDate.of(2020, 8, 24),
        // language=JQL
        expectedJql = """due >= "2020-08-24""""
    )

    @Test
    fun `due greater than equals relative date`() = assertJql(
        Due greaterThanOrEqualTo 2.d.fromNow,
        // language=JQL
        expectedJql = """due >= "2d""""
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
