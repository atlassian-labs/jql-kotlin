package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.time.TimeDuration

interface SlaEqualityFunction : Function
interface SlaComparativeFunction : SlaEqualityFunction

fun breached(): SlaEqualityFunction = object : AbstractFunction("breached"), SlaEqualityFunction {}
fun completed(): SlaEqualityFunction = object : AbstractFunction("completed"), SlaEqualityFunction {}
fun everBreached(): SlaEqualityFunction = object : AbstractFunction("everBreached"), SlaEqualityFunction {}
fun paused(): SlaEqualityFunction = object : AbstractFunction("paused"), SlaEqualityFunction {}
fun running(): SlaEqualityFunction = object : AbstractFunction("running"), SlaEqualityFunction {}
fun withinCalendarHours(): SlaEqualityFunction = object : AbstractFunction("withinCalendarHours"), SlaEqualityFunction {}

fun elapsed(duration: TimeDuration): SlaComparativeFunction =
    object : AbstractFunction("elapsed", listOf(duration.jql)), SlaComparativeFunction {}

fun remaining(duration: TimeDuration): SlaComparativeFunction =
    object : AbstractFunction("remaining", listOf(duration.jql)), SlaComparativeFunction {}
