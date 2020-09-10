package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class UpdatedTest {
    @Test
    fun `updated greater than timestamp`() = assertJql(
        Updated greaterThan LocalDateTime.of(2020, 9, 10, 18, 49),
        // language=JQL
        expectedJql = """updated > "2020-09-10 18:49""""
    )

    @Test
    fun `updated greater than equals timestamp`() = assertJql(
        Updated greaterThanOrEqualTo LocalDateTime.of(2020, 9, 10, 18, 50),
        // language=JQL
        expectedJql = """updated >= "2020-09-10 18:50""""
    )

    @Test
    fun `updated less than timestamp`() = assertJql(
        Updated lessThan LocalDateTime.of(2020, 9, 10, 18, 51),
        // language=JQL
        expectedJql = """updated < "2020-09-10 18:51""""
    )

    @Test
    fun `updated less than equals timestamp`() = assertJql(
        Updated lessThanOrEqualTo LocalDateTime.of(2020, 9, 10, 18, 52),
        // language=JQL
        expectedJql = """updated <= "2020-09-10 18:52""""
    )

    @Test
    fun `updated is empty`() = assertJql(
        Updated iz Empty,
        // language=JQL
        expectedJql = """updated is empty"""
    )

    @Test
    fun `updated is null`() = assertJql(
        Updated iz Null,
        // language=JQL
        expectedJql = """updated is null"""
    )

    @Test
    fun `updated is not empty`() = assertJql(
        Updated izNot Empty,
        // language=JQL
        expectedJql = """updated is not empty"""
    )

    @Test
    fun `updated is not null`() = assertJql(
        Updated izNot Null,
        // language=JQL
        expectedJql = """updated is not null"""
    )
}
