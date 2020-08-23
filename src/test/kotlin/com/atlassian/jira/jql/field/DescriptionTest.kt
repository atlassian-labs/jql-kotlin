package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class DescriptionTest {
    @Test
    fun `description contains value`() = assertJql(
        Description contains "Please see screenshot",
        // language=JQL
        expectedJql = """description ~ "Please see screenshot""""
    )

    @Test
    fun `description does not contain value`() = assertJql(
        Description doesNotContain "abracadabra",
        // language=JQL
        expectedJql = """description !~ "abracadabra""""
    )

    @Test
    fun `description is empty`() = assertJql(
        Description iz Empty,
        // language=JQL
        expectedJql = """description is empty"""
    )

    @Test
    fun `description is null`() = assertJql(
        Description iz Null,
        // language=JQL
        expectedJql = """description is null"""
    )

    @Test
    fun `description is not empty`() = assertJql(
        Description izNot Empty,
        // language=JQL
        expectedJql = """description is not empty"""
    )

    @Test
    fun `description is not null`() = assertJql(
        Description izNot Null,
        // language=JQL
        expectedJql = """description is not null"""
    )
}
