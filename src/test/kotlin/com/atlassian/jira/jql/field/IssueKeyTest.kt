package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.linkedIssues
import com.atlassian.jira.jql.function.watchedIssues
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IssueKeyTest {
    @Test
    fun `resolve by name`() {
        assertEquals(IssueKey, Field.forName("issueKey"))
        assertEquals(IssueKey, SortableField.forName("issueKey"))
    }

    @Test
    fun `resolve by alias`() {
        assertEquals(IssueKey, Field.forName("id"))
        assertEquals(IssueKey, Field.forName("issue"))
        assertEquals(IssueKey, Field.forName("key"))
        assertEquals(IssueKey, SortableField.forName("id"))
        assertEquals(IssueKey, SortableField.forName("issue"))
        assertEquals(IssueKey, SortableField.forName("key"))
    }

    @Test
    fun `issue key equals to string`() = assertJql(
        IssueKey equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueKey = "ABC-123""""
    )

    @Test
    fun `issue key equals to number`() = assertJql(
        IssueKey equalTo 10350,
        // language=JQL
        expectedJql = """issueKey = 10350"""
    )

    @Test
    fun `issue key not equals to string`() = assertJql(
        IssueKey notEqualTo "FOO-456",
        // language=JQL
        expectedJql = """issueKey != "FOO-456""""
    )

    @Test
    fun `issue key not equals to number`() = assertJql(
        IssueKey notEqualTo 123,
        // language=JQL
        expectedJql = """issueKey != 123"""
    )

    @Test
    fun `issue key in strings`() = assertJql(
        IssueKey anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """issueKey in ("foo","bar","baz")"""
    )

    @Test
    fun `issue key in numbers`() = assertJql(
        IssueKey anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """issueKey in (1,2,3)"""
    )

    @Test
    fun `issue key in function`() = assertJql(
        IssueKey anyOf linkedIssues("ABC-12"),
        // language=JQL
        expectedJql = """issueKey in linkedIssues("ABC-12")"""
    )

    @Test
    fun `issue key not in strings`() = assertJql(
        IssueKey noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """issueKey not in ("abra","cadabra")"""
    )

    @Test
    fun `issue key not in numbers`() = assertJql(
        IssueKey noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """issueKey not in (4,5,6)"""
    )

    @Test
    fun `issue key not in function`() = assertJql(
        IssueKey noneOf watchedIssues(),
        // language=JQL
        expectedJql = """issueKey not in watchedIssues()"""
    )

    @Test
    fun `issue key greater than string`() = assertJql(
        IssueKey greaterThan "3.14",
        // language=JQL
        expectedJql = """issueKey > "3.14""""
    )

    @Test
    fun `issue key greater than number`() = assertJql(
        IssueKey greaterThan 987,
        // language=JQL
        expectedJql = """issueKey > 987"""
    )

    @Test
    fun `issue key greater than equals string`() = assertJql(
        IssueKey greaterThanOrEqualTo "foo",
        // language=JQL
        expectedJql = """issueKey >= "foo""""
    )

    @Test
    fun `issue key greater than equals number`() = assertJql(
        IssueKey greaterThanOrEqualTo 567,
        // language=JQL
        expectedJql = """issueKey >= 567"""
    )

    @Test
    fun `issue key less than string`() = assertJql(
        IssueKey lessThan "2.72",
        // language=JQL
        expectedJql = """issueKey < "2.72""""
    )

    @Test
    fun `issue key less than number`() = assertJql(
        IssueKey lessThan 543,
        // language=JQL
        expectedJql = """issueKey < 543"""
    )

    @Test
    fun `issue key less than equals string`() = assertJql(
        IssueKey lessThanOrEqualTo "bar",
        // language=JQL
        expectedJql = """issueKey <= "bar""""
    )

    @Test
    fun `issue key less than equals number`() = assertJql(
        IssueKey lessThanOrEqualTo 890,
        // language=JQL
        expectedJql = """issueKey <= 890"""
    )
}
