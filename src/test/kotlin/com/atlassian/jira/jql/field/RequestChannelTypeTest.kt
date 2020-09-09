package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.Jsd.RequestChannelType
import com.atlassian.jira.jql.field.Jsd.RequestChannelType.anonymousPortal
import com.atlassian.jira.jql.field.Jsd.RequestChannelType.api
import com.atlassian.jira.jql.field.Jsd.RequestChannelType.email
import com.atlassian.jira.jql.field.Jsd.RequestChannelType.jira
import com.atlassian.jira.jql.field.Jsd.RequestChannelType.portal
import org.junit.jupiter.api.Test

internal class RequestChannelTypeTest {
    @Test
    fun `request channel type equals to value`() = assertJql(
        RequestChannelType equalTo jira,
        // language=JQL
        expectedJql = """request-channel-type = jira"""
    )

    @Test
    fun `request channel type not equals to value`() = assertJql(
        RequestChannelType notEqualTo api,
        // language=JQL
        expectedJql = """request-channel-type != api"""
    )

    @Test
    fun `request channel type in values`() = assertJql(
        RequestChannelType anyOf listOf(email, portal),
        // language=JQL
        expectedJql = """request-channel-type in (email,portal)"""
    )

    @Test
    fun `request channel type not in values`() = assertJql(
        RequestChannelType noneOf listOf(portal, anonymousPortal),
        // language=JQL
        expectedJql = """request-channel-type not in (portal,"anonymous portal")"""
    )

    @Test
    fun `request channel type is empty`() = assertJql(
        RequestChannelType iz Empty,
        // language=JQL
        expectedJql = """request-channel-type is empty"""
    )

    @Test
    fun `request channel type is null`() = assertJql(
        RequestChannelType iz Null,
        // language=JQL
        expectedJql = """request-channel-type is null"""
    )

    @Test
    fun `request channel type is not empty`() = assertJql(
        RequestChannelType izNot Empty,
        // language=JQL
        expectedJql = """request-channel-type is not empty"""
    )

    @Test
    fun `request channel type is not null`() = assertJql(
        RequestChannelType izNot Null,
        // language=JQL
        expectedJql = """request-channel-type is not null"""
    )
}
