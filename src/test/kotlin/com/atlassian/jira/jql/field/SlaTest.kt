package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.Sla.TimeToFirstResponse
import com.atlassian.jira.jql.field.Sla.TimeToResolution
import com.atlassian.jira.jql.time.hours
import com.atlassian.jira.jql.time.minutes
import org.junit.jupiter.api.Test

class SlaTest {
    @Test
    fun `time to first response greater than value`() = assertJql(
        TimeToFirstResponse greaterThan 2.hours.fromNow,
        // language=JQL
        expectedJql = """"Time to first response" > "2h""""
    )

    @Test
    fun `time to first response greater than equals value`() = assertJql(
        TimeToResolution greaterThanOrEqualTo 17.minutes.fromNow,
        // language=JQL
        expectedJql = """"Time to resolution" >= "17m""""
    )

    @Test
    fun `custom SLA less than value`() = assertJql(
        Sla.custom("agreement") lessThan (2.hours + 3.minutes).ago,
        // language=JQL
        expectedJql = """agreement < "-2h 3m""""
    )

    @Test
    fun `custom SLA less than equals value`() = assertJql(
        Sla.custom("\"Time to agreement\"") lessThanOrEqualTo 3.hours.fromNow,
        // language=JQL
        expectedJql = """"Time to agreement" <= "3h""""
    )
}
