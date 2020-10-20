package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.time.hours
import com.atlassian.jira.jql.time.minutes
import org.junit.jupiter.api.Test

class SlaFunctionTest {
    @Test
    fun `breached function`() = assertJql(
        breached(),
        expectedJql = "breached()"
    )

    @Test
    fun `completed function`() = assertJql(
        completed(),
        expectedJql = "completed()"
    )

    @Test
    fun `everBreached function`() = assertJql(
        everBreached(),
        expectedJql = "everBreached()"
    )

    @Test
    fun `paused function`() = assertJql(
        paused(),
        expectedJql = "paused()"
    )

    @Test
    fun `running function`() = assertJql(
        running(),
        expectedJql = "running()"
    )

    @Test
    fun `withinCalendarHours function`() = assertJql(
        withinCalendarHours(),
        expectedJql = "withinCalendarHours()"
    )

    @Test
    fun `elapsed function`() = assertJql(
        elapsed(5.hours),
        expectedJql = """elapsed("5h")"""
    )

    @Test
    fun `remaining function`() = assertJql(
        remaining(12.minutes),
        expectedJql = """remaining("12m")"""
    )
}
