package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.JqlEntity
import com.atlassian.jira.jql.escape

interface ApprovalsFunction : JqlEntity

fun approved(): ApprovalsFunction = object : Function("approved"), ApprovalsFunction {}
fun approver(vararg users: String): ApprovalsFunction =
    object : Function("approver", users.requireAtLeastOneArgument().map { it.escape() }), ApprovalsFunction {}

fun myApproval(): ApprovalsFunction = object : Function("myApproval"), ApprovalsFunction {}
fun myPending(): ApprovalsFunction = object : Function("myPending"), ApprovalsFunction {}
fun pending(): ApprovalsFunction = object : Function("pending"), ApprovalsFunction {}
fun pendingBy(vararg users: String): ApprovalsFunction =
    object : Function("pendingBy", users.requireAtLeastOneArgument().map { it.escape() }), ApprovalsFunction {}
