package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.Identifier
import com.atlassian.jira.jql.TemporalFormatter.dateTime
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.field.IssueLinkType
import com.atlassian.jira.jql.time.RelativeDateTime
import java.time.LocalDateTime

interface IssueFunction : Function

fun issueHistory(): IssueFunction = object : AbstractFunction("issueHistory"), IssueFunction {}
fun linkedIssues(issueKey: String, linkType: IssueLinkType.Value? = null): IssueFunction =
    object : AbstractFunction("linkedIssues", listOfNotNull(issueKey.escape(), linkType?.jql)), IssueFunction {}

fun linkedIssues(issueId: Identifier, linkType: IssueLinkType.Value? = null): IssueFunction =
    object : AbstractFunction("linkedIssues", listOfNotNull(issueId.toString(), linkType?.jql)), IssueFunction {}

fun votedIssues(): IssueFunction = object : AbstractFunction("votedIssues"), IssueFunction {}
fun watchedIssues(): IssueFunction = object : AbstractFunction("watchedIssues"), IssueFunction {}

// Can't use optional arguments at this level:
// - need to avoid signature ambiguity
// - need to restrict calling with just `until` argument defined by name
fun updatedBy(user: String): IssueFunction = object : AbstractFunction("updatedBy", listOf(user.escape())), IssueFunction {}
fun updatedBy(user: String, from: LocalDateTime, until: LocalDateTime? = null): IssueFunction {
    until?.let { ensureFromEarlierThanUntil(from, it) }
    return object : AbstractFunction("updatedBy", listOfNotNull(user.escape(), from.format(), until?.format())), IssueFunction {}
}

fun updatedBy(user: String, from: RelativeDateTime, until: RelativeDateTime? = null): IssueFunction =
    object : AbstractFunction("updatedBy", listOfNotNull(user.escape(), from.jql, until?.jql)), IssueFunction {}

private fun ensureFromEarlierThanUntil(from: LocalDateTime, until: LocalDateTime) {
    if (from > until) throw IllegalArgumentException("From timestamp must be earlier than until timestamp")
}

private fun LocalDateTime.format() = dateTime.format(this).escape()
