package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class ParentTest {
    @Test
    fun `parent equals to string`() = assertJql(
        Parent equalTo "TEST-1234",
        // language=JQL
        expectedJql = """parent = "TEST-1234""""
    )

    @Test
    fun `parent not equals to string`() = assertJql(
        Parent notEqualTo "TEST-5678",
        // language=JQL
        expectedJql = """parent != "TEST-5678""""
    )

    @Test
    fun `parent in strings`() = assertJql(
        Parent anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """parent in ("foo","bar","baz")"""
    )

    @Test
    fun `parent not in strings`() = assertJql(
        Parent noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """parent not in ("abra","cadabra")"""
    )
}
