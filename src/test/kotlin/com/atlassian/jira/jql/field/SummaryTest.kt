package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class SummaryTest {
    @Test
    fun `summary contains value`() = assertJql(
        Summary contains "Error saving file",
        // language=JQL
        expectedJql = """summary ~ "Error saving file""""
    )

    @Test
    fun `summary does not contain value`() = assertJql(
        Summary doesNotContain "abracadabra",
        // language=JQL
        expectedJql = """summary !~ "abracadabra""""
    )

    @Test
    fun `summary is empty`() = assertJql(
        Summary iz Empty,
        // language=JQL
        expectedJql = """summary is empty"""
    )

    @Test
    fun `summary is null`() = assertJql(
        Summary iz Null,
        // language=JQL
        expectedJql = """summary is null"""
    )

    @Test
    fun `summary is not empty`() = assertJql(
        Summary izNot Empty,
        // language=JQL
        expectedJql = """summary is not empty"""
    )

    @Test
    fun `summary is not null`() = assertJql(
        Summary izNot Null,
        // language=JQL
        expectedJql = """summary is not null"""
    )
}
