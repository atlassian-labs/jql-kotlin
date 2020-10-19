package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.field.ids
import org.junit.jupiter.api.Test

class VersionFunctionTest {
    @Test
    fun `latestReleasedVersion allows no arguments`() {
        assertJql(
            latestReleasedVersion(),
            expectedJql = "latestReleasedVersion()"
        )
        assertJql(
            latestReleasedVersion(ids()),
            expectedJql = "latestReleasedVersion()"
        )
    }

    @Test
    fun `latestReleasedVersion with string arguments`() = assertJql(
        latestReleasedVersion("foo", "bar"),
        expectedJql = """latestReleasedVersion("foo","bar")"""
    )

    @Test
    fun `latestReleasedVersion with identifier arguments`() = assertJql(
        latestReleasedVersion(ids(1, 2, 3)),
        expectedJql = """latestReleasedVersion(1,2,3)"""
    )

    @Test
    fun `earliestUnreleasedVersion allows no arguments`() {
        assertJql(
            earliestUnreleasedVersion(),
            expectedJql = "earliestUnreleasedVersion()"
        )
        assertJql(
            earliestUnreleasedVersion(ids()),
            expectedJql = "earliestUnreleasedVersion()"
        )
    }

    @Test
    fun `earliestUnreleasedVersion with string arguments`() = assertJql(
        earliestUnreleasedVersion("foo", "bar"),
        expectedJql = """earliestUnreleasedVersion("foo","bar")"""
    )

    @Test
    fun `earliestUnreleasedVersion with identifier arguments`() = assertJql(
        earliestUnreleasedVersion(ids(1, 2, 3)),
        expectedJql = """earliestUnreleasedVersion(1,2,3)"""
    )
}
