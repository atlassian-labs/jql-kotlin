package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ChangeControlTypeTest {
    @Test
    fun `resolve by name`() {
        assertEquals(ChangeControlType, Field.forName("change-control-type"))
        assertNull(SortableField.forName("change-control-type"))
    }

    @Test
    fun `change control type equals to value`() = assertJql(
        ChangeControlType equalTo "uncontrolled",
        // language=JQL
        expectedJql = """change-control-type = "uncontrolled""""
    )

    @Test
    fun `change control type not equals to value`() = assertJql(
        ChangeControlType notEqualTo "uncontrolled",
        // language=JQL
        expectedJql = """change-control-type != "uncontrolled""""
    )

    @Test
    fun `change control type in values`() = assertJql(
        ChangeControlType anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """change-control-type in ("foo","bar","baz")"""
    )

    @Test
    fun `change control type not in values`() = assertJql(
        ChangeControlType noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """change-control-type not in ("abra","cadabra")"""
    )

    @Test
    fun `change control type is empty`() = assertJql(
        ChangeControlType iz Empty,
        // language=JQL
        expectedJql = """change-control-type is empty"""
    )

    @Test
    fun `change control type is null`() = assertJql(
        ChangeControlType iz Null,
        // language=JQL
        expectedJql = """change-control-type is null"""
    )

    @Test
    fun `change control type is not empty`() = assertJql(
        ChangeControlType izNot Empty,
        // language=JQL
        expectedJql = """change-control-type is not empty"""
    )

    @Test
    fun `change control type is not null`() = assertJql(
        ChangeControlType izNot Null,
        // language=JQL
        expectedJql = """change-control-type is not null"""
    )
}
