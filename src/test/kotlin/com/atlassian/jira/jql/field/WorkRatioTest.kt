package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class WorkRatioTest {
    @Test
    fun `work ratio equals to value`() = assertJql(
        WorkRatio equalTo 55,
        // language=JQL
        expectedJql = """workRatio = 55"""
    )

    @Test
    fun `work ratio not equals to value`() = assertJql(
        WorkRatio notEqualTo 100,
        // language=JQL
        expectedJql = """workRatio != 100"""
    )

    @Test
    fun `work ratio in values`() = assertJql(
        WorkRatio anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """workRatio in (1,2,3)"""
    )

    @Test
    fun `work ratio not in values`() = assertJql(
        WorkRatio noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """workRatio not in (4,5,6)"""
    )

    @Test
    fun `work ratio greater than value`() = assertJql(
        WorkRatio greaterThan 50,
        // language=JQL
        expectedJql = """workRatio > 50"""
    )

    @Test
    fun `work ratio greater than equals value`() = assertJql(
        WorkRatio greaterThanOrEqualTo 30,
        // language=JQL
        expectedJql = """workRatio >= 30"""
    )

    @Test
    fun `work ratio less than value`() = assertJql(
        WorkRatio lessThan 90,
        // language=JQL
        expectedJql = """workRatio < 90"""
    )

    @Test
    fun `work ratio less than equals value`() = assertJql(
        WorkRatio lessThanOrEqualTo 75,
        // language=JQL
        expectedJql = """workRatio <= 75"""
    )

    @Test
    fun `work ratio is empty`() = assertJql(
        WorkRatio iz Empty,
        // language=JQL
        expectedJql = """workRatio is empty"""
    )

    @Test
    fun `work ratio is null`() = assertJql(
        WorkRatio iz Null,
        // language=JQL
        expectedJql = """workRatio is null"""
    )

    @Test
    fun `work ratio is not empty`() = assertJql(
        WorkRatio izNot Empty,
        // language=JQL
        expectedJql = """workRatio is not empty"""
    )

    @Test
    fun `work ratio is not null`() = assertJql(
        WorkRatio izNot Null,
        // language=JQL
        expectedJql = """workRatio is not null"""
    )
}
