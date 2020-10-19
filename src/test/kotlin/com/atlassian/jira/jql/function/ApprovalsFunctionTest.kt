package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.field.ids
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApprovalsFunctionTest {
    @Test
    fun `approver requires at least one argument`() {
        assertThrows<IllegalArgumentException> { approver() }
        assertThrows<IllegalArgumentException> { approver(ids()) }
    }

    @Test
    fun `pendingBy requires at least one argument`() {
        assertThrows<IllegalArgumentException> { pendingBy() }
    }
}
