package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class AttachmentsTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Attachments, Field.forName("attachments"))
        assertNull(SortableField.forName("attachments"))
    }

    @Test
    fun `attachments is empty`() = assertJql(
        Attachments iz Empty,
        // language=JQL
        expectedJql = """attachments is empty"""
    )

    @Test
    fun `attachments is null`() = assertJql(
        Attachments iz Null,
        // language=JQL
        expectedJql = """attachments is null"""
    )

    @Test
    fun `attachments is not empty`() = assertJql(
        Attachments izNot Empty,
        // language=JQL
        expectedJql = """attachments is not empty"""
    )

    @Test
    fun `attachments is not null`() = assertJql(
        Attachments izNot Null,
        // language=JQL
        expectedJql = """attachments is not null"""
    )
}
