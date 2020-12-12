package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.function.earliestUnreleasedVersion
import com.atlassian.jira.jql.function.latestReleasedVersion
import com.atlassian.jira.jql.function.releasedVersions
import com.atlassian.jira.jql.function.unreleasedVersions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AffectedVersionTest {
    @Test
    fun `resolve by name`() {
        assertEquals(AffectedVersion, Field.forName("affectedVersion"))
    }

    @Test
    fun `affected version equals to string`() = assertJql(
        AffectedVersion equalTo "3.14",
        // language=JQL
        expectedJql = """affectedVersion = "3.14""""
    )

    @Test
    fun `affected version equals to number`() = assertJql(
        AffectedVersion equalTo 10350,
        // language=JQL
        expectedJql = """affectedVersion = 10350"""
    )

    @Test
    fun `affected version equals to function`() = assertJql(
        AffectedVersion equalTo latestReleasedVersion("foo"),
        // language=JQL
        expectedJql = """affectedVersion = latestReleasedVersion("foo")"""
    )

    @Test
    fun `affected version not equals to string`() = assertJql(
        AffectedVersion notEqualTo "Big Ted",
        // language=JQL
        expectedJql = """affectedVersion != "Big Ted""""
    )

    @Test
    fun `affected version not equals to number`() = assertJql(
        AffectedVersion notEqualTo 123,
        // language=JQL
        expectedJql = """affectedVersion != 123"""
    )

    @Test
    fun `affected version not equals to function`() = assertJql(
        AffectedVersion notEqualTo earliestUnreleasedVersion(),
        // language=JQL
        expectedJql = """affectedVersion != earliestUnreleasedVersion()"""
    )

    @Test
    fun `affected version in strings`() = assertJql(
        AffectedVersion anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """affectedVersion in ("foo","bar","baz")"""
    )

    @Test
    fun `affected version in numbers`() = assertJql(
        AffectedVersion anyOf ids(1, 2, 3),
        // language=JQL
        expectedJql = """affectedVersion in (1,2,3)"""
    )

    @Test
    fun `affected version in function`() = assertJql(
        AffectedVersion anyOf releasedVersions("bar"),
        // language=JQL
        expectedJql = """affectedVersion in releasedVersions("bar")"""
    )

    @Test
    fun `affected version not in strings`() = assertJql(
        AffectedVersion noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """affectedVersion not in ("abra","cadabra")"""
    )

    @Test
    fun `affected version not in numbers`() = assertJql(
        AffectedVersion noneOf ids(4, 5, 6),
        // language=JQL
        expectedJql = """affectedVersion not in (4,5,6)"""
    )

    @Test
    fun `affected version not in function`() = assertJql(
        AffectedVersion noneOf unreleasedVersions(),
        // language=JQL
        expectedJql = """affectedVersion not in unreleasedVersions()"""
    )

    @Test
    fun `affected version greater than string`() = assertJql(
        AffectedVersion greaterThan "3.14",
        // language=JQL
        expectedJql = """affectedVersion > "3.14""""
    )

    @Test
    fun `affected version greater than number`() = assertJql(
        AffectedVersion greaterThan 987,
        // language=JQL
        expectedJql = """affectedVersion > 987"""
    )

    @Test
    fun `affected version greater than equals string`() = assertJql(
        AffectedVersion greaterThanOrEqualTo "foo",
        // language=JQL
        expectedJql = """affectedVersion >= "foo""""
    )

    @Test
    fun `affected version greater than equals number`() = assertJql(
        AffectedVersion greaterThanOrEqualTo 567,
        // language=JQL
        expectedJql = """affectedVersion >= 567"""
    )

    @Test
    fun `affected version less than string`() = assertJql(
        AffectedVersion lessThan "2.72",
        // language=JQL
        expectedJql = """affectedVersion < "2.72""""
    )

    @Test
    fun `affected version less than number`() = assertJql(
        AffectedVersion lessThan 543,
        // language=JQL
        expectedJql = """affectedVersion < 543"""
    )

    @Test
    fun `affected version less than equals string`() = assertJql(
        AffectedVersion lessThanOrEqualTo "bar",
        // language=JQL
        expectedJql = """affectedVersion <= "bar""""
    )

    @Test
    fun `affected version less than equals number`() = assertJql(
        AffectedVersion lessThanOrEqualTo 890,
        // language=JQL
        expectedJql = """affectedVersion <= 890"""
    )

    @Test
    fun `affected version is empty`() = assertJql(
        AffectedVersion iz Empty,
        // language=JQL
        expectedJql = """affectedVersion is empty"""
    )

    @Test
    fun `affected version is null`() = assertJql(
        AffectedVersion iz Null,
        // language=JQL
        expectedJql = """affectedVersion is null"""
    )

    @Test
    fun `affected version is not empty`() = assertJql(
        AffectedVersion izNot Empty,
        // language=JQL
        expectedJql = """affectedVersion is not empty"""
    )

    @Test
    fun `affected version is not null`() = assertJql(
        AffectedVersion izNot Null,
        // language=JQL
        expectedJql = """affectedVersion is not null"""
    )
}
