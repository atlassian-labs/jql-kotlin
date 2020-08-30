package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.Jsd.Organization
import org.junit.jupiter.api.Test

internal class OrganizationTest {
    @Test
    fun `organization equals to string`() = assertJql(
        Organization equalTo "Atlassian",
        // language=JQL
        expectedJql = """organizations = "Atlassian""""
    )

    @Test
    fun `organization not equals to string`() = assertJql(
        Organization notEqualTo "Charlie",
        // language=JQL
        expectedJql = """organizations != "Charlie""""
    )

    @Test
    fun `organization in strings`() = assertJql(
        Organization anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """organizations in ("foo","bar","baz")"""
    )

    @Test
    fun `organization not in strings`() = assertJql(
        Organization noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """organizations not in ("abra","cadabra")"""
    )
}
