package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TextTest {
    @Test
    fun `resolve by name`() {
        assertEquals(Text, Field.forName("text"))
    }

    @Test
    fun `text contains value`() = assertJql(
        Text contains "full screen",
        // language=JQL
        expectedJql = """text ~ "full screen""""
    )
}
