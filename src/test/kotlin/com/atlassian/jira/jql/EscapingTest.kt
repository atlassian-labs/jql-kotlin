package com.atlassian.jira.jql

import com.atlassian.jira.jql.field.Created
import com.atlassian.jira.jql.field.Text
import org.junit.jupiter.api.Test

internal class EscapingTest {
    @Test
    fun `special characters are escaped`() = assertJql(
        Text contains "\\FOO\t\n\"BAR\"" orderBy Created.asc,
        """text ~ "\\FOO \"BAR\"" ORDER BY created ASC"""
    )
}
