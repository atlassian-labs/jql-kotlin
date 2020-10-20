package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

class SprintFunctionTest {
    @Test
    fun `openSprints function`() = assertJql(
        openSprints(),
        expectedJql = """openSprints()"""
    )

    @Test
    fun `closedSprints function`() = assertJql(
        closedSprints(),
        expectedJql = """closedSprints()"""
    )

    @Test
    fun `futureSprints function`() = assertJql(
        futureSprints(),
        expectedJql = """futureSprints()"""
    )
}
