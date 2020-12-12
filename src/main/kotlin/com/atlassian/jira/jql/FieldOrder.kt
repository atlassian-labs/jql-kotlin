package com.atlassian.jira.jql

import com.atlassian.jira.jql.field.SortableField

sealed class FieldOrder(private val field: SortableField, private val order: String) : JqlEntity {
    class Ascending(field: SortableField) : FieldOrder(field, "ASC")
    class Descending(field: SortableField) : FieldOrder(field, "DESC")

    override fun toJql() = "${field.name} $order"
}
