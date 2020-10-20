package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.IssueLinkType
import com.atlassian.jira.jql.time.days
import com.atlassian.jira.jql.time.hours
import com.atlassian.jira.jql.time.minutes
import com.atlassian.jira.jql.time.weeks
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime

class IssueFunctionTest {
    @Test
    fun `issueHistory function`() = assertJql(
        issueHistory(),
        expectedJql = "issueHistory()"
    )

    @Test
    fun `linkedIssues with issue key`() {
        assertJql(
            linkedIssues("ABC-123"),
            expectedJql = """linkedIssues("ABC-123")"""
        )
        assertJql(
            linkedIssues("ABC-123", IssueLinkType.isBlockedBy),
            expectedJql = """linkedIssues("ABC-123","is blocked by")"""
        )
    }

    @Test
    fun `linkedIssues with issue id`() {
        assertJql(
            linkedIssues(123),
            expectedJql = "linkedIssues(123)"
        )
        assertJql(
            linkedIssues(123, IssueLinkType.blocks),
            expectedJql = "linkedIssues(123,blocks)"
        )
    }

    @Test
    fun `votedIssues function`() = assertJql(
        votedIssues(),
        expectedJql = "votedIssues()"
    )

    @Test
    fun `watchedIssues function`() = assertJql(
        watchedIssues(),
        expectedJql = "watchedIssues()"
    )

    @Test
    fun `updatedBy with single argument`() = assertJql(
        updatedBy("John Smith"),
        expectedJql = """updatedBy("John Smith")"""
    )

    @Test
    fun `updatedBy with from timestamp`() = assertJql(
        updatedBy("John Smith", LocalDateTime.of(2020, 10, 21, 8, 56)),
        expectedJql = """updatedBy("John Smith","2020-10-21 08:56")"""
    )

    @Test
    fun `updatedBy with from and until timestamps`() = assertJql(
        updatedBy(
            "John Smith",
            LocalDateTime.of(2020, 10, 21, 8, 56),
            LocalDateTime.of(2020, 10, 21, 9, 1)
        ),
        expectedJql = """updatedBy("John Smith","2020-10-21 08:56","2020-10-21 09:01")"""
    )

    @Test
    fun `updatedBy with from relative time`() = assertJql(
        updatedBy("John Smith", 5.days.ago),
        expectedJql = """updatedBy("John Smith","-5d")"""
    )

    @Test
    fun `updatedBy with from and until relative time`() = assertJql(
        updatedBy("John Smith", 10.weeks.ago, 5.hours.ago),
        expectedJql = """updatedBy("John Smith","-10w","-5h")"""
    )

    @Test
    fun `updatedBy doesn't allow from timestamp later than until timestamp`() {
        updatedBy(
            "foo",
            LocalDateTime.of(2020, 10, 21, 9, 5),
            LocalDateTime.of(2020, 10, 21, 9, 5)
        )
        assertThrows<IllegalArgumentException> {
            updatedBy(
                "foo",
                LocalDateTime.of(2020, 10, 21, 9, 5),
                LocalDateTime.of(2020, 10, 21, 9, 4)
            )
        }
    }

    @Test
    @Disabled("Relative time is not comparable yet")
    fun `updatedBy doesn't allow from relative time later than until relative time`() {
        updatedBy("foo", 24.hours.ago, 24.hours.ago)
        assertThrows<IllegalArgumentException> {
            updatedBy("foo", (23.hours + 59.minutes).ago, 24.hours.ago)
        }
    }
}
