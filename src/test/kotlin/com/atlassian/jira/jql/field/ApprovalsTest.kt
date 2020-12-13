package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.approver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ApprovalsTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Approvals, Field.forName("approvals"))
        assertNull(SortableField.forName("approvals"))
    }

    @Test
    fun `approvals equals to function`() = assertJql(
        Approvals equalTo approver("John Smith", "bob@mycompany.com"),
        // language=JQL
        expectedJql = """approvals = approver("John Smith","bob@mycompany.com")"""
    )
}
