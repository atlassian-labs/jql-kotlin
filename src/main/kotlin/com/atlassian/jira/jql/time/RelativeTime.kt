package com.atlassian.jira.jql.time

interface RelativeDateTime {
    val jql: String
}

interface RelativeDate : RelativeDateTime
interface RelativeTime : RelativeDateTime

internal fun relativeDateTime(jql: String, negative: Boolean = false) = object : RelativeDateTime {
    override val jql = if (negative) jql.negative() else jql
}

internal fun relativeDate(jql: String, negative: Boolean = false) = object : RelativeDate {
    override val jql = if (negative) jql.negative() else jql
}

internal fun relativeTime(jql: String, negative: Boolean = false) = object : RelativeTime {
    override val jql = if (negative) jql.negative() else jql
}

private fun String.negative() = "\"-${trim('"')}\""
