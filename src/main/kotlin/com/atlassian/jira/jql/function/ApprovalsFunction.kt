package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.field.Identifiers

interface ApprovalsFunction : Function

fun approved(): ApprovalsFunction = object : AbstractFunction("approved"), ApprovalsFunction {}

fun approver(vararg users: String): ApprovalsFunction =
    object : AbstractFunction("approver", users.requireAtLeastOneArgument().map { it.escape() }), ApprovalsFunction {}

fun approver(userIds: Identifiers): ApprovalsFunction =
    object : AbstractFunction("approver", userIds.identifiers.map { it.toString() }), ApprovalsFunction {}

fun myApproval(): ApprovalsFunction = object : AbstractFunction("myApproval"), ApprovalsFunction {}

fun myPending(): ApprovalsFunction = object : AbstractFunction("myPending"), ApprovalsFunction {}

fun pending(): ApprovalsFunction = object : AbstractFunction("pending"), ApprovalsFunction {}

fun pendingBy(vararg users: String): ApprovalsFunction =
    object : AbstractFunction("pendingBy", users.requireAtLeastOneArgument().map { it.escape() }), ApprovalsFunction {}
