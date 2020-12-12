package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class StatusCategoryTest {
    @Test
    fun `status category equals to string`() = assertJql(
        StatusCategory equalTo "Done",
        // language=JQL
        expectedJql = """statusCategory = "Done""""
    )

    @Test
    fun `status category equals to number`() = assertJql(
        StatusCategory equalTo 1,
        // language=JQL
        expectedJql = """statusCategory = 1"""
    )

    @Test
    fun `status category not equals to string`() = assertJql(
        StatusCategory notEqualTo "To Do",
        // language=JQL
        expectedJql = """statusCategory != "To Do""""
    )

    @Test
    fun `status category not equals to number`() = assertJql(
        StatusCategory notEqualTo 123,
        // language=JQL
        expectedJql = """statusCategory != 123"""
    )

    @Test
    fun `status category in strings`() = assertJql(
        StatusCategory anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """statusCategory in ("foo","bar","baz")"""
    )

    @Test
    fun `status category in numbers`() = assertJql(
        StatusCategory anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """statusCategory in (1,2,3)"""
    )

    @Test
    fun `status category not in strings`() = assertJql(
        StatusCategory noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """statusCategory not in ("abra","cadabra")"""
    )

    @Test
    fun `status category not in numbers`() = assertJql(
        StatusCategory noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """statusCategory not in (4,5,6)"""
    )

    @Test
    fun `status category is empty`() = assertJql(
        StatusCategory iz Empty,
        // language=JQL
        expectedJql = """statusCategory is empty"""
    )

    @Test
    fun `status category is null`() = assertJql(
        StatusCategory iz Null,
        // language=JQL
        expectedJql = """statusCategory is null"""
    )

    @Test
    fun `status category is not empty`() = assertJql(
        StatusCategory izNot Empty,
        // language=JQL
        expectedJql = """statusCategory is not empty"""
    )

    @Test
    fun `status category is not null`() = assertJql(
        StatusCategory izNot Null,
        // language=JQL
        expectedJql = """statusCategory is not null"""
    )
}
