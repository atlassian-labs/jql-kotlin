package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.IssueLinkType
import org.junit.jupiter.api.Test

class IssueFunctionTest {
    @Test
    fun `issueHistory function`() = assertJql(
        issueHistory(),
        expectedJql = "issueHistory()"
    )

    @Test
    fun `linkedIssues with issue key`() {
        assertJql(
            linkedIssues("ABC-123"),
            expectedJql = """linkedIssues("ABC-123")"""
        )
        assertJql(
            linkedIssues("ABC-123", IssueLinkType.isBlockedBy),
            expectedJql = """linkedIssues("ABC-123","is blocked by")"""
        )
    }

    @Test
    fun `linkedIssues with issue id`() {
        assertJql(
            linkedIssues(123),
            expectedJql = """linkedIssues(123)"""
        )
        assertJql(
            linkedIssues(123, IssueLinkType.blocks),
            expectedJql = """linkedIssues(123,blocks)"""
        )
    }

    @Test
    fun `votedIssues function`() = assertJql(
        votedIssues(),
        expectedJql = """votedIssues()"""
    )

    @Test
    fun `watchedIssues function`() = assertJql(
        watchedIssues(),
        expectedJql = """watchedIssues()"""
    )
}
