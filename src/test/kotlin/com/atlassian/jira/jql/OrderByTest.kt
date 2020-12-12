package com.atlassian.jira.jql

import org.junit.jupiter.api.Test

internal class OrderByTest {
    @Test
    fun `order by field ascending`() = assertJql(
        orderBy(FieldOrder.Ascending(sortableField("field"))),
        expectedJql = "ORDER BY field ASC"
    )

    @Test
    fun `order by field descending`() = assertJql(
        orderBy(FieldOrder.Descending(sortableField("field"))),
        expectedJql = "ORDER BY field DESC"
    )

    @Test
    fun `order by multiple fields`() = assertJql(
        orderBy(
            listOf(
                FieldOrder.Descending(sortableField("fieldDesc")),
                FieldOrder.Ascending(sortableField("fieldAsc"))
            )
        ),
        expectedJql = "ORDER BY fieldDesc DESC, fieldAsc ASC"
    )
}
