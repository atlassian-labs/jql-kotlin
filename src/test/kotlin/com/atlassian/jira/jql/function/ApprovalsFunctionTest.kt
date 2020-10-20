package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApprovalsFunctionTest {
    @Test
    fun `approved function`() = assertJql(
        approved(),
        expectedJql = "approved()"
    )

    @Test
    fun `approver requires at least one argument`() {
        assertThrows<IllegalArgumentException> { approver() }
    }

    @Test
    fun `approver with string arguments`() =
        assertJql(
            approver("foo", "bar"),
            expectedJql = """approver("foo","bar")"""
        )

    @Test
    fun `approver with string collection argument`() =
        assertJql(
            approver(listOf("foo", "bar")),
            expectedJql = """approver("foo","bar")"""
        )

    @Test
    fun `myApproval function`() = assertJql(
        myApproval(),
        expectedJql = "myApproval()"
    )

    @Test
    fun `myPending function`() = assertJql(
        myPending(),
        expectedJql = "myPending()"
    )

    @Test
    fun `pending function`() = assertJql(
        pending(),
        expectedJql = "pending()"
    )

    @Test
    fun `pendingBy requires at least one argument`() {
        assertThrows<IllegalArgumentException> { pendingBy() }
    }

    @Test
    fun `pendingBy with string arguments`() =
        assertJql(
            pendingBy("foo", "bar"),
            expectedJql = """pendingBy("foo","bar")"""
        )

    @Test
    fun `pendingBy with string collection argument`() =
        assertJql(
            pendingBy(listOf("foo", "bar")),
            expectedJql = """pendingBy("foo","bar")"""
        )
}
