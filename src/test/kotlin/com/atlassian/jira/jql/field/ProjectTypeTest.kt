package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.ProjectType.Value.JiraCore
import com.atlassian.jira.jql.field.ProjectType.Value.JiraOps
import com.atlassian.jira.jql.field.ProjectType.Value.JiraServiceDesk
import com.atlassian.jira.jql.field.ProjectType.Value.JiraSoftware
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ProjectTypeTest {
    @Test
    fun `resolve by name`() {
        assertEquals(ProjectType, Field.forName("projectType"))
    }

    @Test
    fun `project type equals to value`() = assertJql(
        ProjectType equalTo JiraCore,
        // language=JQL
        expectedJql = """projectType = business"""
    )

    @Test
    fun `project type not equals to value`() = assertJql(
        ProjectType notEqualTo JiraSoftware,
        // language=JQL
        expectedJql = """projectType != software"""
    )

    @Test
    fun `project type in values`() = assertJql(
        ProjectType anyOf listOf(JiraServiceDesk, JiraSoftware),
        // language=JQL
        expectedJql = """projectType in (service_desk,software)"""
    )

    @Test
    fun `project type not in values`() = assertJql(
        ProjectType noneOf listOf(JiraCore, JiraOps),
        // language=JQL
        expectedJql = """projectType not in (business,ops)"""
    )
}
