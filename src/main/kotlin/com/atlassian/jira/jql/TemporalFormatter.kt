package com.atlassian.jira.jql

import java.time.format.DateTimeFormatter

internal object TemporalFormatter {
    val date: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val dateTime: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
}
