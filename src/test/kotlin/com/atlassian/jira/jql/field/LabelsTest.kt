package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class LabelsTest {
    @Test
    fun `labels equals to value`() = assertJql(
        Labels equalTo "label1",
        // language=JQL
        expectedJql = """labels = "label1""""
    )

    @Test
    fun `labels not equals to value`() = assertJql(
        Labels notEqualTo "label2",
        // language=JQL
        expectedJql = """labels != "label2""""
    )

    @Test
    fun `labels in values`() = assertJql(
        Labels anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """labels in ("foo","bar","baz")"""
    )

    @Test
    fun `labels not in values`() = assertJql(
        Labels noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """labels not in ("abra","cadabra")"""
    )

    @Test
    fun `labels is empty`() = assertJql(
        Labels iz Empty,
        // language=JQL
        expectedJql = """labels is empty"""
    )

    @Test
    fun `labels is null`() = assertJql(
        Labels iz Null,
        // language=JQL
        expectedJql = """labels is null"""
    )

    @Test
    fun `labels is not empty`() = assertJql(
        Labels izNot Empty,
        // language=JQL
        expectedJql = """labels is not empty"""
    )

    @Test
    fun `labels is not null`() = assertJql(
        Labels izNot Null,
        // language=JQL
        expectedJql = """labels is not null"""
    )
}
