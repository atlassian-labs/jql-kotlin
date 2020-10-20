package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.escape

interface ApprovalsFunction : Function

fun approved(): ApprovalsFunction = object : AbstractFunction("approved"), ApprovalsFunction {}

fun approver(vararg users: String): ApprovalsFunction = approver(users.toList())

fun approver(users: Collection<String>): ApprovalsFunction =
    object : AbstractFunction("approver", users.requireAtLeastOneArgument().map { it.escape() }), ApprovalsFunction {}

fun myApproval(): ApprovalsFunction = object : AbstractFunction("myApproval"), ApprovalsFunction {}

fun myPending(): ApprovalsFunction = object : AbstractFunction("myPending"), ApprovalsFunction {}

fun pending(): ApprovalsFunction = object : AbstractFunction("pending"), ApprovalsFunction {}

fun pendingBy(vararg users: String): ApprovalsFunction = pendingBy(users.toList())

fun pendingBy(users: Collection<String>): ApprovalsFunction =
    object : AbstractFunction("pendingBy", users.requireAtLeastOneArgument().map { it.escape() }), ApprovalsFunction {}
