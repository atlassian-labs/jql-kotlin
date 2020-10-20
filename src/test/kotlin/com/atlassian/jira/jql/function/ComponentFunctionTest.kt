package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class ComponentFunctionTest {
    @Test
    fun `componentsLeadByUser without arguments`() = assertJql(
        componentsLeadByUser(),
        expectedJql = "componentsLeadByUser()"
    )

    @Test
    fun `componentsLeadByUser with an argument`() = assertJql(
        componentsLeadByUser("foo"),
        expectedJql = """componentsLeadByUser("foo")"""
    )
}
