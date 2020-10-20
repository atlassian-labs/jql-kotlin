package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.approver
import org.junit.jupiter.api.Test

class ApprovalsTest {
    @Test
    fun `approvals equals to function`() = assertJql(
        Approvals equalTo approver("John Smith", "bob@mycompany.com"),
        // language=JQL
        expectedJql = """approvals = approver("John Smith","bob@mycompany.com")"""
    )
}
