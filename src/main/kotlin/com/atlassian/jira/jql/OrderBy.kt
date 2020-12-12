package com.atlassian.jira.jql

fun orderBy(vararg fieldWithOrder: FieldOrder): String =
    orderBy(fieldWithOrder.asList())

fun orderBy(fieldsWithOrder: List<FieldOrder>): String =
    fieldsWithOrder.joinToString(separator = ", ") { it.toJql() }
        .takeIf { it.isNotBlank() }
        ?.let { orderBy -> "ORDER BY $orderBy" }
        ?: ""
