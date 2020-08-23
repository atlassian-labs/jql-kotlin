package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test

internal class FixVersionTest {
    @Test
    fun `fix version equals to string`() = assertJql(
        FixVersion equalTo "3.14",
        // language=JQL
        expectedJql = """fixVersion = "3.14""""
    )

    @Test
    fun `fix version equals to number`() = assertJql(
        FixVersion equalTo 10350,
        // language=JQL
        expectedJql = """fixVersion = 10350"""
    )

    @Test
    fun `fix version not equals to string`() = assertJql(
        FixVersion notEqualTo "Big Ted",
        // language=JQL
        expectedJql = """fixVersion != "Big Ted""""
    )

    @Test
    fun `fix version not equals to number`() = assertJql(
        FixVersion notEqualTo 123,
        // language=JQL
        expectedJql = """fixVersion != 123"""
    )

    @Test
    fun `fix version in strings`() = assertJql(
        FixVersion anyOf listOf("foo", "bar", "baz"),
        // language=JQL
        expectedJql = """fixVersion in ("foo","bar","baz")"""
    )

    @Test
    fun `fix version in numbers`() = assertJql(
        FixVersion anyOf numbers(1, 2, 3),
        // language=JQL
        expectedJql = """fixVersion in (1,2,3)"""
    )

    @Test
    fun `fix version not in strings`() = assertJql(
        FixVersion noneOf listOf("abra", "cadabra"),
        // language=JQL
        expectedJql = """fixVersion not in ("abra","cadabra")"""
    )

    @Test
    fun `fix version not in numbers`() = assertJql(
        FixVersion noneOf numbers(4, 5, 6),
        // language=JQL
        expectedJql = """fixVersion not in (4,5,6)"""
    )

    @Test
    fun `fix version greater than string`() = assertJql(
        FixVersion greaterThan "3.14",
        // language=JQL
        expectedJql = """fixVersion > "3.14""""
    )

    @Test
    fun `fix version greater than number`() = assertJql(
        FixVersion greaterThan 987,
        // language=JQL
        expectedJql = """fixVersion > 987"""
    )

    @Test
    fun `fix version greater than equals string`() = assertJql(
        FixVersion greaterThanOrEqualTo "foo",
        // language=JQL
        expectedJql = """fixVersion >= "foo""""
    )

    @Test
    fun `fix version greater than equals number`() = assertJql(
        FixVersion greaterThanOrEqualTo 567,
        // language=JQL
        expectedJql = """fixVersion >= 567"""
    )

    @Test
    fun `fix version less than string`() = assertJql(
        FixVersion lessThan "2.72",
        // language=JQL
        expectedJql = """fixVersion < "2.72""""
    )

    @Test
    fun `fix version less than number`() = assertJql(
        FixVersion lessThan 543,
        // language=JQL
        expectedJql = """fixVersion < 543"""
    )

    @Test
    fun `fix version less than equals string`() = assertJql(
        FixVersion lessThanOrEqualTo "bar",
        // language=JQL
        expectedJql = """fixVersion <= "bar""""
    )

    @Test
    fun `fix version less than equals number`() = assertJql(
        FixVersion lessThanOrEqualTo 890,
        // language=JQL
        expectedJql = """fixVersion <= 890"""
    )

    @Test
    fun `fix version is empty`() = assertJql(
        FixVersion iz Empty,
        // language=JQL
        expectedJql = """fixVersion is empty"""
    )

    @Test
    fun `fix version is null`() = assertJql(
        FixVersion iz Null,
        // language=JQL
        expectedJql = """fixVersion is null"""
    )

    @Test
    fun `fix version is not empty`() = assertJql(
        FixVersion izNot Empty,
        // language=JQL
        expectedJql = """fixVersion is not empty"""
    )

    @Test
    fun `fix version is not null`() = assertJql(
        FixVersion izNot Null,
        // language=JQL
        expectedJql = """fixVersion is not null"""
    )
}
