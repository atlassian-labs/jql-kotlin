package com.atlassian.jira.jql

private val specialCharacters = "([\"\\\\])".toRegex()
private val whitespace = "\\s+".toRegex()
fun String.escape() = trim()
    .replace(specialCharacters, "\\\\$1")
    .replace(whitespace, " ")
    .takeIf { it.isNotBlank() }
    ?.let { "\"$it\"" }
    .orEmpty()
