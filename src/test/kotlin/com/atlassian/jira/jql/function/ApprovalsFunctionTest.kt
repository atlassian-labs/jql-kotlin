package com.atlassian.jira.jql.function

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApprovalsFunctionTest {
    @Test
    fun `approver requires at least one argument`() {
        assertThrows<IllegalArgumentException> { approver() }
    }

    @Test
    fun `pendingBy requires at least one argument`() {
        assertThrows<IllegalArgumentException> { pendingBy() }
    }
}
