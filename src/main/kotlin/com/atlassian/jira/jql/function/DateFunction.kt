package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.time.RelativeDateTime

interface DateFunction : Function

fun currentLogin(): DateFunction = object : AbstractFunction("currentLogin"), DateFunction {}
fun lastLogin(): DateFunction = object : AbstractFunction("lastLogin"), DateFunction {}
fun now(): DateFunction = object : AbstractFunction("now"), DateFunction {}
fun startOfDay(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("startOfDay", offset)
fun startOfWeek(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("startOfWeek", offset)
fun startOfMonth(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("startOfMonth", offset)
fun startOfYear(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("startOfYear", offset)
fun endOfDay(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("endOfDay", offset)
fun endOfWeek(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("endOfWeek", offset)
fun endOfMonth(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("endOfMonth", offset)
fun endOfYear(offset: RelativeDateTime? = null): DateFunction = relativeDateTimeFunction("endOfYear", offset)

private fun relativeDateTimeFunction(name: String, offset: RelativeDateTime? = null): DateFunction =
    object : AbstractFunction(name, listOfNotNull(offset?.jql)), DateFunction {}
