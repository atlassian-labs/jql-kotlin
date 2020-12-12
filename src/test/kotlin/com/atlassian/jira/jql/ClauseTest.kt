package com.atlassian.jira.jql

import org.junit.jupiter.api.Test

class ClauseTest {
    @Test
    fun `clause and clause`() = assertJql(
        Clause("left") and Clause("right"),
        expectedJql = "left AND right"
    )

    @Test
    fun `clause and clause in parentheses`() = assertJql(
        Clause("left") and { Clause("right") },
        expectedJql = "left AND (right)"
    )

    @Test
    fun `clause in parentheses and clause`() = assertJql(
        { Clause("left") } and Clause("right"),
        expectedJql = "(left) AND right"
    )

    @Test
    fun `clause in parentheses and clause in parentheses`() = assertJql(
        { Clause("left") } and { Clause("right") },
        expectedJql = "(left) AND (right)"
    )

    @Test
    fun `clause or clause`() = assertJql(
        Clause("left") or Clause("right"),
        expectedJql = "left OR right"
    )

    @Test
    fun `clause or clause in parentheses`() = assertJql(
        Clause("left") or { Clause("right") },
        expectedJql = "left OR (right)"
    )

    @Test
    fun `clause in parentheses or clause`() = assertJql(
        { Clause("left") } or Clause("right"),
        expectedJql = "(left) OR right"
    )

    @Test
    fun `clause in parentheses or clause in parentheses`() = assertJql(
        { Clause("left") } or { Clause("right") },
        expectedJql = "(left) OR (right)"
    )

    @Test
    fun `clause order by field ascending`() = assertJql(
        Clause("clause") orderBy FieldOrder.Ascending(sortableField("field")),
        expectedJql = "clause ORDER BY field ASC"
    )

    @Test
    fun `clause order by field descending`() = assertJql(
        Clause("clause") orderBy FieldOrder.Descending(sortableField("field")),
        expectedJql = "clause ORDER BY field DESC"
    )

    @Test
    fun `clause order by multiple fields`() = assertJql(
        Clause("clause") orderBy listOf(
            FieldOrder.Descending(sortableField("fieldDesc")),
            FieldOrder.Ascending(sortableField("fieldAsc"))
        ),
        expectedJql = "clause ORDER BY fieldDesc DESC, fieldAsc ASC"
    )
}
