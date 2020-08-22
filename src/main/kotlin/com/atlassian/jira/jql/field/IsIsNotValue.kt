package com.atlassian.jira.jql.field

sealed class IsIsNotValue(val jql: String)
object Empty : IsIsNotValue("empty")
object Null : IsIsNotValue("null")
