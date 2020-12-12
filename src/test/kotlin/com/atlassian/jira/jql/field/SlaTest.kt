package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.Sla.TimeToFirstResponse
import com.atlassian.jira.jql.field.Sla.TimeToResolution
import com.atlassian.jira.jql.function.breached
import com.atlassian.jira.jql.function.completed
import com.atlassian.jira.jql.function.elapsed
import com.atlassian.jira.jql.function.remaining
import com.atlassian.jira.jql.time.h
import com.atlassian.jira.jql.time.hours
import com.atlassian.jira.jql.time.minutes
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SlaTest {
    @Test
    fun `resolve by name`() {
        assertEquals(TimeToResolution, Field.forName("Time to resolution"))
        assertEquals(TimeToFirstResponse, Field.forName("Time to first response"))
    }

    @Test
    fun `SLA equals to function`() = assertJql(
        TimeToFirstResponse equalTo breached(),
        // language=JQL
        expectedJql = """"Time to first response" = breached()"""
    )

    @Test
    fun `SLA not equals to function`() = assertJql(
        TimeToResolution notEqualTo completed(),
        // language=JQL
        expectedJql = """"Time to resolution" != completed()"""
    )

    @Test
    fun `SLA greater than value`() = assertJql(
        TimeToFirstResponse greaterThan 2.hours.fromNow,
        // language=JQL
        expectedJql = """"Time to first response" > "2h""""
    )

    @Test
    fun `SLA greater than function`() = assertJql(
        TimeToFirstResponse greaterThan elapsed(3.minutes),
        // language=JQL
        expectedJql = """"Time to first response" > elapsed("3m")"""
    )

    @Test
    fun `SLA greater than equals value`() = assertJql(
        TimeToResolution greaterThanOrEqualTo 17.minutes.fromNow,
        // language=JQL
        expectedJql = """"Time to resolution" >= "17m""""
    )

    @Test
    fun `SLA greater than equals function`() = assertJql(
        TimeToResolution greaterThanOrEqualTo remaining(5.hours),
        // language=JQL
        expectedJql = """"Time to resolution" >= remaining("5h")"""
    )

    @Test
    fun `custom SLA less than value`() = assertJql(
        Sla.custom("agreement") lessThan (2.hours + 3.minutes).ago,
        // language=JQL
        expectedJql = """agreement < "-2h 3m""""
    )

    @Test
    fun `custom SLA less than function`() = assertJql(
        Sla.custom("agreement") lessThan remaining(1.h),
        // language=JQL
        expectedJql = """agreement < remaining("1h")"""
    )

    @Test
    fun `custom SLA less than equals value`() = assertJql(
        Sla.custom("\"Time to agreement\"") lessThanOrEqualTo 3.hours.fromNow,
        // language=JQL
        expectedJql = """"Time to agreement" <= "3h""""
    )

    @Test
    fun `custom SLA less than equals function`() = assertJql(
        Sla.custom("\"Time to agreement\"") lessThanOrEqualTo elapsed(2.hours),
        // language=JQL
        expectedJql = """"Time to agreement" <= elapsed("2h")"""
    )
}
