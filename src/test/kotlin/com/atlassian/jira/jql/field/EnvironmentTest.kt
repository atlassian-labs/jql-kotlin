package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class EnvironmentTest {
    @Test
    fun `environment contains value`() = assertJql(
        Environment contains "Third floor",
        // language=JQL
        expectedJql = """environment ~ "Third floor""""
    )

    @Test
    fun `environment does not contain value`() = assertJql(
        Environment doesNotContain "abracadabra",
        // language=JQL
        expectedJql = """environment !~ "abracadabra""""
    )

    @Test
    fun `environment is empty`() = assertJql(
        Environment iz Empty,
        // language=JQL
        expectedJql = """environment is empty"""
    )

    @Test
    fun `environment is null`() = assertJql(
        Environment iz Null,
        // language=JQL
        expectedJql = """environment is null"""
    )

    @Test
    fun `environment is not empty`() = assertJql(
        Environment izNot Empty,
        // language=JQL
        expectedJql = """environment is not empty"""
    )

    @Test
    fun `environment is not null`() = assertJql(
        Environment izNot Null,
        // language=JQL
        expectedJql = """environment is not null"""
    )
}
