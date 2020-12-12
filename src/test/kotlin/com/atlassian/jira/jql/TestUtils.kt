package com.atlassian.jira.jql

import com.atlassian.jira.jql.field.SortableField
import org.junit.jupiter.api.Assertions.assertEquals

fun assertJql(actualJql: JqlEntity, expectedJql: String) = assertJql(actualJql.toJql(), expectedJql)
fun assertJql(actualJql: String, expectedJql: String) = assertEquals(expectedJql.trim(), actualJql)

fun sortableField(name: String) = object : SortableField {
    override val name = name
}
