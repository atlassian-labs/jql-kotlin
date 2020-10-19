package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.JqlEntity

abstract class Function(
    private val name: String,
    private val arguments: List<String> = emptyList(),
) : JqlEntity {
    override fun toJql() = "$name(${arguments.joinToString(separator = ",")})"
}

internal fun <T> Array<out T>.requireAtLeastOneArgument() =
    takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException("At least one argument is required for a function")
