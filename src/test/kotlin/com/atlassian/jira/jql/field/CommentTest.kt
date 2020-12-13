package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class CommentTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Comment, Field.forName("comment"))
        assertNull(SortableField.forName("comment"))
    }

    @Test
    fun `comment contains value`() = assertJql(
        Comment contains "\"My PC is quite old",
        // language=JQL
        expectedJql = """comment ~ "\"My PC is quite old""""
    )

    @Test
    fun `comment does not contain value`() = assertJql(
        Comment doesNotContain "abracadabra",
        // language=JQL
        expectedJql = """comment !~ "abracadabra""""
    )
}
