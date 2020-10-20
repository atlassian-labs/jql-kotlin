package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.Identifier
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.field.IssueLinkType

interface IssueFunction : Function

fun issueHistory(): IssueFunction = object : AbstractFunction("issueHistory"), IssueFunction {}
fun linkedIssues(issueKey: String, linkType: IssueLinkType.Value? = null): IssueFunction =
    object : AbstractFunction("linkedIssues", listOfNotNull(issueKey.escape(), linkType?.jql)), IssueFunction {}
fun linkedIssues(issueId: Identifier, linkType: IssueLinkType.Value? = null): IssueFunction =
    object : AbstractFunction("linkedIssues", listOfNotNull(issueId.toString(), linkType?.jql)), IssueFunction {}
fun votedIssues(): IssueFunction = object : AbstractFunction("votedIssues"), IssueFunction {}
fun watchedIssues(): IssueFunction = object : AbstractFunction("watchedIssues"), IssueFunction {}
