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

internal class IssueLinkTypeTest {
    @Test
    fun `issue link equals to is blocked by`() = assertJql(
        IssueLinkType equalTo isBlockedBy,
        // language=JQL
        expectedJql = """issueLinkType = "is blocked by""""
    )

    @Test
    fun `issue link equals to blocks`() = assertJql(
        IssueLinkType equalTo blocks,
        // language=JQL
        expectedJql = """issueLinkType = blocks"""
    )

    @Test
    fun `issue link equals to is cloned by`() = assertJql(
        IssueLinkType equalTo isClonedBy,
        // language=JQL
        expectedJql = """issueLinkType = "is cloned by""""
    )

    @Test
    fun `issue link equals to clones`() = assertJql(
        IssueLinkType equalTo clones,
        // language=JQL
        expectedJql = """issueLinkType = clones"""
    )

    @Test
    fun `issue link equals to is duplicated by`() = assertJql(
        IssueLinkType equalTo isDuplicatedBy,
        // language=JQL
        expectedJql = """issueLinkType = "is duplicated by""""
    )

    @Test
    fun `issue link equals to duplicates`() = assertJql(
        IssueLinkType equalTo duplicates,
        // language=JQL
        expectedJql = """issueLinkType = duplicates"""
    )

    @Test
    fun `issue link equals to split from`() = assertJql(
        IssueLinkType equalTo splitFrom,
        // language=JQL
        expectedJql = """issueLinkType = "split from""""
    )

    @Test
    fun `issue link equals to split to`() = assertJql(
        IssueLinkType equalTo splitTo,
        // language=JQL
        expectedJql = """issueLinkType = "split to""""
    )

    @Test
    fun `issue link equals to is caused by`() = assertJql(
        IssueLinkType equalTo isCausedBy,
        // language=JQL
        expectedJql = """issueLinkType = "is caused by""""
    )

    @Test
    fun `issue link equals to causes`() = assertJql(
        IssueLinkType equalTo causes,
        // language=JQL
        expectedJql = """issueLinkType = causes"""
    )

    @Test
    fun `issue link equals to custom issue link`() = assertJql(
        IssueLinkType equalTo IssueLinkType.custom("\"is test for\""),
        // language=JQL
        expectedJql = """issueLinkType = "is test for""""
    )

    @Test
    fun `issue link not equals to value`() = assertJql(
        IssueLinkType notEqualTo blocks,
        // language=JQL
        expectedJql = """issueLinkType != blocks"""
    )

    @Test
    fun `issue link in values`() = assertJql(
        IssueLinkType anyOf listOf(blocks, isBlockedBy),
        // language=JQL
        expectedJql = """issueLinkType in (blocks,"is blocked by")"""
    )

    @Test
    fun `issue link not in values`() = assertJql(
        IssueLinkType noneOf listOf(clones, isClonedBy),
        // language=JQL
        expectedJql = """issueLinkType not in (clones,"is cloned by")"""
    )
}
