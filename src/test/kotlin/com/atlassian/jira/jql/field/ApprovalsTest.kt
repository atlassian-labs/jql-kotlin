package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.approved
import com.atlassian.jira.jql.function.approver
import com.atlassian.jira.jql.function.myApproval
import com.atlassian.jira.jql.function.myPending
import com.atlassian.jira.jql.function.pending
import com.atlassian.jira.jql.function.pendingBy
import org.junit.jupiter.api.Test

class ApprovalsTest {
    @Test
    fun `approvals equals to approved()`() = assertJql(
        Approvals equalTo approved(),
        // language=JQL
        expectedJql = """approvals = approved()"""
    )

    @Test
    fun `approvals equals to approver()`() = assertJql(
        Approvals equalTo approver("John Smith", "bob@mycompany.com"),
        // language=JQL
        expectedJql = """approvals = approver("John Smith","bob@mycompany.com")"""
    )

    @Test
    fun `approvals equals to myApproval()`() = assertJql(
        Approvals equalTo myApproval(),
        // language=JQL
        expectedJql = """approvals = myApproval()"""
    )

    @Test
    fun `approvals equals to myPending()`() = assertJql(
        Approvals equalTo myPending(),
        // language=JQL
        expectedJql = """approvals = myPending()"""
    )

    @Test
    fun `approvals equals to pending()`() = assertJql(
        Approvals equalTo pending(),
        // language=JQL
        expectedJql = """approvals = pending()"""
    )

    @Test
    fun `approvals equals to pendingBy()`() = assertJql(
        Approvals equalTo pendingBy("John Smith"),
        // language=JQL
        expectedJql = """approvals = pendingBy("John Smith")"""
    )
}
