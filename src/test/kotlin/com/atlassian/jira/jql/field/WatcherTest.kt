package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class WatcherTest {
    @Test
    fun `watcher equals to value`() = assertJql(
        Watcher equalTo "Jill Jones",
        // language=JQL
        expectedJql = """watcher = "Jill Jones""""
    )

    @Test
    fun `watcher not equals to value`() = assertJql(
        Watcher notEqualTo "bob@mycompany.com",
        // language=JQL
        expectedJql = """watcher != "bob@mycompany.com""""
    )

    @Test
    fun `watcher in values`() = assertJql(
        Watcher anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """watcher in ("foo","bar","baz")"""
    )

    @Test
    fun `watcher not in values`() = assertJql(
        Watcher noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """watcher not in ("abra","cadabra")"""
    )

    @Test
    fun `watcher is empty`() = assertJql(
        Watcher iz Empty,
        // language=JQL
        expectedJql = """watcher is empty"""
    )

    @Test
    fun `watcher is null`() = assertJql(
        Watcher iz Null,
        // language=JQL
        expectedJql = """watcher is null"""
    )

    @Test
    fun `watcher is not empty`() = assertJql(
        Watcher izNot Empty,
        // language=JQL
        expectedJql = """watcher is not empty"""
    )

    @Test
    fun `watcher is not null`() = assertJql(
        Watcher izNot Null,
        // language=JQL
        expectedJql = """watcher is not null"""
    )
}
