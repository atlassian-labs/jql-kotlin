package com.atlassian.jira.jql

import org.junit.jupiter.api.Test

internal class OrderByTest {
    @Test
    fun `order by field ascending`() = assertJql(
        orderBy(FieldOrder.Ascending("field")),
        expectedJql = "ORDER BY field ASC"
    )

    @Test
    fun `order by field descending`() = assertJql(
        orderBy(FieldOrder.Descending("field")),
        expectedJql = "ORDER BY field DESC"
    )

    @Test
    fun `order by multiple fields`() = assertJql(
        orderBy(listOf(FieldOrder.Descending("fieldDesc"), FieldOrder.Ascending("fieldAsc"))),
        expectedJql = "ORDER BY fieldDesc DESC, fieldAsc ASC"
    )
}
