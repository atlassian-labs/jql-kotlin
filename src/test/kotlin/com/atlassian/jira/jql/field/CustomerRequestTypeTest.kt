package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CustomerRequestTypeTest {
    @Test
    fun `resolve by name`() {
        assertEquals(CustomerRequestType, Field.forName("Customer Request Type"))
    }

    @Test
    fun `affected version equals to value`() = assertJql(
        CustomerRequestType equalTo "Request a new account",
        // language=JQL
        expectedJql = """"Customer Request Type" = "Request a new account""""
    )

    @Test
    fun `affected version not equals to value`() = assertJql(
        CustomerRequestType notEqualTo "sd/system-access",
        // language=JQL
        expectedJql = """"Customer Request Type" != "sd/system-access""""
    )

    @Test
    fun `affected version in values`() = assertJql(
        CustomerRequestType anyOf listOf("Request a new account", "Get IT Help"),
        // language=JQL
        expectedJql = """"Customer Request Type" in ("Request a new account","Get IT Help")"""
    )

    @Test
    fun `affected version not in values`() = assertJql(
        CustomerRequestType noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """"Customer Request Type" not in ("abra","cadabra")"""
    )
}
