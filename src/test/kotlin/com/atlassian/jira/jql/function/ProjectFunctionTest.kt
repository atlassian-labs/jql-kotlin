package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class ProjectFunctionTest {
    @Test
    fun `projectsLeadByUser without arguments`() = assertJql(
        projectsLeadByUser(),
        expectedJql = "projectsLeadByUser()"
    )

    @Test
    fun `projectsLeadByUser with an argument`() = assertJql(
        projectsLeadByUser("foo"),
        expectedJql = """projectsLeadByUser("foo")"""
    )

    @Test
    fun `projectsWhereUserHasPermission function`() = assertJql(
        projectsWhereUserHasPermission("bar"),
        expectedJql = """projectsWhereUserHasPermission("bar")"""
    )

    @Test
    fun `projectsWhereUserHasRole function`() = assertJql(
        projectsWhereUserHasRole("baz"),
        expectedJql = """projectsWhereUserHasRole("baz")"""
    )
}
