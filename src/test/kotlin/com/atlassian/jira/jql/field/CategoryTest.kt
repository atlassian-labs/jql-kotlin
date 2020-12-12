package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CategoryTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Category, Field.forName("category"))
    }

    @Test
    fun `category equals to value`() = assertJql(
        Category equalTo "Alphabet Projects",
        // language=JQL
        expectedJql = """category = "Alphabet Projects""""
    )

    @Test
    fun `category not equals to value`() = assertJql(
        Category notEqualTo "Other",
        // language=JQL
        expectedJql = """category != "Other""""
    )

    @Test
    fun `category in values`() = assertJql(
        Category anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """category in ("foo","bar","baz")"""
    )

    @Test
    fun `category not in values`() = assertJql(
        Category noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """category not in ("abra","cadabra")"""
    )

    @Test
    fun `category is empty`() = assertJql(
        Category iz Empty,
        // language=JQL
        expectedJql = """category is empty"""
    )

    @Test
    fun `category is null`() = assertJql(
        Category iz Null,
        // language=JQL
        expectedJql = """category is null"""
    )

    @Test
    fun `category is not empty`() = assertJql(
        Category izNot Empty,
        // language=JQL
        expectedJql = """category is not empty"""
    )

    @Test
    fun `category is not null`() = assertJql(
        Category izNot Null,
        // language=JQL
        expectedJql = """category is not null"""
    )
}
