package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.JqlEntity

interface Function : JqlEntity

abstract class AbstractFunction(
    private val name: String,
    private val arguments: List<String> = emptyList(),
) : Function {
    override fun toJql() = "$name(${arguments.joinToString(separator = ",")})"
}

internal fun <T : Any> Array<out T>.requireAtLeastOneArgument() =
    takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException("At least one argument is required for a function")
