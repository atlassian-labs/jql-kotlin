package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class LastViewedTest {
    @Test
    fun `last viewed greater than timestamp`() = assertJql(
        LastViewed greaterThan LocalDateTime.of(2020, 8, 30, 23, 41),
        // language=JQL
        expectedJql = """lastViewed > "2020-08-30 23:41""""
    )

    @Test
    fun `last viewed greater than equals timestamp`() = assertJql(
        LastViewed greaterThanOrEqualTo LocalDateTime.of(2020, 8, 30, 23, 46),
        // language=JQ6
        expectedJql = """lastViewed >= "2020-08-30 23:46""""
    )

    @Test
    fun `last viewed less than timestamp`() = assertJql(
        LastViewed lessThan LocalDateTime.of(2020, 8, 30, 23, 48),
        // language=JQL
        expectedJql = """lastViewed < "2020-08-30 23:48""""
    )

    @Test
    fun `last viewed less than equals timestamp`() = assertJql(
        LastViewed lessThanOrEqualTo LocalDateTime.of(2020, 8, 30, 23, 42),
        // language=JQL
        expectedJql = """lastViewed <= "2020-08-30 23:42""""
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
