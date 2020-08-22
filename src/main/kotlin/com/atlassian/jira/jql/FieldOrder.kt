package com.atlassian.jira.jql

sealed class FieldOrder(private val fieldName: String, private val order: String) : JqlEntity {
    class Ascending(name: String) : FieldOrder(name, "ASC")
    class Descending(name: String) : FieldOrder(name, "DESC")

    override fun toJql() = "$fieldName $order"
}
