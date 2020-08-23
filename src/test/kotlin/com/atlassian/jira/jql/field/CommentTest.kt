package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class CommentTest {
    @Test
    fun `comment contains value`() = assertJql(
        Comment contains " \"My PC is quite\told\t",
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
