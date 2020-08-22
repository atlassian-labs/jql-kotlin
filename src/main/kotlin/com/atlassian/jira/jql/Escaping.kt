package com.atlassian.jira.jql

private val whitespace = "\\s+".toRegex()
fun String.escape() = trim()
    .replace("\"", "\\\"")
    .replace(whitespace, " ")
    .takeIf { it.isNotBlank() }
    ?.let { "\"$it\"" }
    .orEmpty()
