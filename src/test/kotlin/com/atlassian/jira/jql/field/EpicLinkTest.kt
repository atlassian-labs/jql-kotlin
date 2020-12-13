package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.issueHistory
import com.atlassian.jira.jql.function.votedIssues
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EpicLinkTest {
    @Test
    fun `resolve by name`() {
        assertEquals(EpicLink, Field.forName("epic link"))
        assertEquals(EpicLink, SortableField.forName("epic link"))
    }

    @Test
    fun `epic link equals to string`() = assertJql(
        EpicLink equalTo "ANERDS-31",
        // language=JQL
        expectedJql = """"epic link" = "ANERDS-31""""
    )

    @Test
    fun `epic link equals to number`() = assertJql(
        EpicLink equalTo 20500,
        // language=JQL
        expectedJql = """"epic link" = 20500"""
    )

    @Test
    fun `epic link not equals to string`() = assertJql(
        EpicLink notEqualTo "Jupiter",
        // language=JQL
        expectedJql = """"epic link" != "Jupiter""""
    )

    @Test
    fun `epic link not equals to number`() = assertJql(
        EpicLink notEqualTo 123,
        // language=JQL
        expectedJql = """"epic link" != 123"""
    )

    @Test
    fun `epic link in strings`() = assertJql(
        EpicLink anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """"epic link" in ("foo","bar","baz")"""
    )

    @Test
    fun `epic link in numbers`() = assertJql(
        EpicLink anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """"epic link" in (1,2,3)"""
    )

    @Test
    fun `epic link in function`() = assertJql(
        EpicLink anyOf issueHistory(),
        // language=JQL
        expectedJql = """"epic link" in issueHistory()"""
    )

    @Test
    fun `epic link not in strings`() = assertJql(
        EpicLink noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """"epic link" not in ("abra","cadabra")"""
    )

    @Test
    fun `epic link not in numbers`() = assertJql(
        EpicLink noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """"epic link" not in (4,5,6)"""
    )

    @Test
    fun `epic link not in function`() = assertJql(
        EpicLink noneOf votedIssues(),
        // language=JQL
        expectedJql = """"epic link" not in votedIssues()"""
    )

    @Test
    fun `epic link is empty`() = assertJql(
        EpicLink iz Empty,
        // language=JQL
        expectedJql = """"epic link" is empty"""
    )

    @Test
    fun `epic link is null`() = assertJql(
        EpicLink iz Null,
        // language=JQL
        expectedJql = """"epic link" is null"""
    )

    @Test
    fun `epic link is not empty`() = assertJql(
        EpicLink izNot Empty,
        // language=JQL
        expectedJql = """"epic link" is not empty"""
    )

    @Test
    fun `epic link is not null`() = assertJql(
        EpicLink izNot Null,
        // language=JQL
        expectedJql = """"epic link" is not null"""
    )
}
