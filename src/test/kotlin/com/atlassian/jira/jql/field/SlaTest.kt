package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.RelativeTime
import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.Jsd.Sla
import com.atlassian.jira.jql.field.Jsd.Sla.TimeToFirstResponse
import com.atlassian.jira.jql.field.Jsd.Sla.TimeToResolution
import org.junit.jupiter.api.Test

class SlaTest {
    @Test
    fun `time to first response equals to value`() = assertJql(
        TimeToFirstResponse equalTo RelativeTime(hours = 1),
        // language=JQL
        expectedJql = """"Time to first response" = "1h""""
    )

    @Test
    fun `time to resolution not equals to value`() = assertJql(
        TimeToResolution notEqualTo RelativeTime(minutes = 10),
        // language=JQL
        expectedJql = """"Time to resolution" != "10m""""
    )

    @Test
    fun `time to first response greater than value`() = assertJql(
        TimeToFirstResponse greaterThan RelativeTime(hours = 2),
        // language=JQL
        expectedJql = """"Time to first response" > "2h""""
    )

    @Test
    fun `time to first response greater than equals value`() = assertJql(
        TimeToResolution greaterThanOrEqualTo RelativeTime(minutes = 17),
        // language=JQL
        expectedJql = """"Time to resolution" >= "17m""""
    )

    @Test
    fun `custom SLA less than value`() = assertJql(
        Sla.custom("agreement") lessThan RelativeTime(hours = 2, minutes = 3),
        // language=JQL
        expectedJql = """agreement < "2h 3m""""
    )

    @Test
    fun `custom SLA less than equals value`() = assertJql(
        Sla.custom("\"Time to agreement\"") lessThanOrEqualTo RelativeTime(hours = 3),
        // language=JQL
        expectedJql = """"Time to agreement" <= "3h""""
    )
}
