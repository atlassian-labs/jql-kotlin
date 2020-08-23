package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class CreatedTest {
    @Test
    fun `created greater than timestamp`() = assertJql(
        Created greaterThan LocalDateTime.of(2020, 8, 24, 1, 20),
        // language=JQL
        expectedJql = """created > "2020-08-24 01:20""""
    )

    @Test
    fun `created greater than equals timestamp`() = assertJql(
        Created greaterThanOrEqualTo LocalDateTime.of(2020, 8, 24, 1, 37),
        // language=JQL
        expectedJql = """created >= "2020-08-24 01:37""""
    )

    @Test
    fun `created less than timestamp`() = assertJql(
        Created lessThan LocalDateTime.of(2020, 8, 24, 1, 38),
        // language=JQL
        expectedJql = """created < "2020-08-24 01:38""""
    )

    @Test
    fun `created less than equals timestamp`() = assertJql(
        Created lessThanOrEqualTo LocalDateTime.of(2020, 8, 24, 1, 39),
        // language=JQL
        expectedJql = """created <= "2020-08-24 01:39""""
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