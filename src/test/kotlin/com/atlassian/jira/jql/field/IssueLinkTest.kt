package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.IssueLinkType.blocks
import com.atlassian.jira.jql.field.IssueLinkType.causes
import com.atlassian.jira.jql.field.IssueLinkType.clones
import com.atlassian.jira.jql.field.IssueLinkType.duplicates
import com.atlassian.jira.jql.field.IssueLinkType.isBlockedBy
import com.atlassian.jira.jql.field.IssueLinkType.isCausedBy
import com.atlassian.jira.jql.field.IssueLinkType.isClonedBy
import com.atlassian.jira.jql.field.IssueLinkType.isDuplicatedBy
import com.atlassian.jira.jql.field.IssueLinkType.splitFrom
import com.atlassian.jira.jql.field.IssueLinkType.splitTo
import org.junit.jupiter.api.Test

class IssueLinkTest {
    @Test
    fun `issue link equals to value`() = assertJql(
        IssueLink equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueLink = "ABC-123""""
    )

    @Test
    fun `issue link not equals to value`() = assertJql(
        IssueLink notEqualTo "ABC-456",
        // language=JQL
        expectedJql = """issueLink != "ABC-456""""
    )

    @Test
    fun `issue link in values`() = assertJql(
        IssueLink anyOf listOf("ABC-123", "ABC-456"),
        // language=JQL
        expectedJql = """issueLink in ("ABC-123","ABC-456")"""
    )

    @Test
    fun `issue link not in values`() = assertJql(
        IssueLink noneOf listOf("ABC-123", "ABC-456"),
        // language=JQL
        expectedJql = """issueLink not in ("ABC-123","ABC-456")"""
    )

    @Test
    fun `issue link is blocked by`() = assertJql(
        IssueLink.ofType(isBlockedBy) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueIsBlockedBy = "ABC-123""""
    )

    @Test
    fun `issue link blocks`() = assertJql(
        IssueLink.ofType(blocks) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueBlocks = "ABC-123""""
    )

    @Test
    fun `issue link is cloned by`() = assertJql(
        IssueLink.ofType(isClonedBy) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueIsClonedBy = "ABC-123""""
    )

    @Test
    fun `issue link clones`() = assertJql(
        IssueLink.ofType(clones) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueClones = "ABC-123""""
    )

    @Test
    fun `issue link is duplicated by`() = assertJql(
        IssueLink.ofType(isDuplicatedBy) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueIsDuplicatedBy = "ABC-123""""
    )

    @Test
    fun `issue link duplicates`() = assertJql(
        IssueLink.ofType(duplicates) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueDuplicates = "ABC-123""""
    )

    @Test
    fun `issue link split from`() = assertJql(
        IssueLink.ofType(splitFrom) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueSplitFrom = "ABC-123""""
    )

    @Test
    fun `issue link split to`() = assertJql(
        IssueLink.ofType(splitTo) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueSplitTo = "ABC-123""""
    )

    @Test
    fun `issue link is caused by`() = assertJql(
        IssueLink.ofType(isCausedBy) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueIsCausedBy = "ABC-123""""
    )

    @Test
    fun `issue link causes`() = assertJql(
        IssueLink.ofType(causes) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueCauses = "ABC-123""""
    )

    @Test
    fun `custom issue link`() = assertJql(
        IssueLink.ofType(IssueLinkType.custom("\"is test for\"")) equalTo "ABC-123",
        // language=JQL
        expectedJql = """issueIsTestFor = "ABC-123""""
    )
}
