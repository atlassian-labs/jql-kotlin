package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.assertJql
import com.atlassian.jira.jql.time.d
import com.atlassian.jira.jql.time.h
import com.atlassian.jira.jql.time.w
import org.junit.jupiter.api.Test

class DateFunctionTest {
    @Test
    fun `currentLogin function`() = assertJql(
        currentLogin(),
        expectedJql = "currentLogin()"
    )

    @Test
    fun `lastLogin function`() = assertJql(
        lastLogin(),
        expectedJql = "lastLogin()"
    )

    @Test
    fun `now function`() = assertJql(
        now(),
        expectedJql = "now()"
    )

    @Test
    fun `startOfDay without arguments`() = assertJql(
        startOfDay(),
        expectedJql = "startOfDay()"
    )

    @Test
    fun `startOfDay with an argument`() = assertJql(
        startOfDay(1.w.ago),
        expectedJql = """startOfDay("-1w")"""
    )

    @Test
    fun `startOfWeek without arguments`() = assertJql(
        startOfWeek(),
        expectedJql = "startOfWeek()"
    )

    @Test
    fun `startOfWeek with an argument`() = assertJql(
        startOfWeek(5.d.fromNow),
        expectedJql = """startOfWeek("5d")"""
    )

    @Test
    fun `startOfMonth without arguments`() = assertJql(
        startOfMonth(),
        expectedJql = "startOfMonth()"
    )

    @Test
    fun `startOfMonth with an argument`() = assertJql(
        startOfMonth(15.d.ago),
        expectedJql = """startOfMonth("-15d")"""
    )

    @Test
    fun `startOfYear without arguments`() = assertJql(
        startOfYear(),
        expectedJql = "startOfYear()"
    )

    @Test
    fun `startOfYear with an argument`() = assertJql(
        startOfYear(48.h.fromNow),
        expectedJql = """startOfYear("48h")"""
    )

    @Test
    fun `endOfDay without arguments`() = assertJql(
        endOfDay(),
        expectedJql = "endOfDay()"
    )

    @Test
    fun `endOfDay with an argument`() = assertJql(
        endOfDay(1.w.ago),
        expectedJql = """endOfDay("-1w")"""
    )

    @Test
    fun `endOfWeek without arguments`() = assertJql(
        endOfWeek(),
        expectedJql = "endOfWeek()"
    )

    @Test
    fun `endOfWeek with an argument`() = assertJql(
        endOfWeek(5.d.fromNow),
        expectedJql = """endOfWeek("5d")"""
    )

    @Test
    fun `endOfMonth without arguments`() = assertJql(
        endOfMonth(),
        expectedJql = "endOfMonth()"
    )

    @Test
    fun `endOfMonth with an argument`() = assertJql(
        endOfMonth(15.d.ago),
        expectedJql = """endOfMonth("-15d")"""
    )

    @Test
    fun `endOfYear without arguments`() = assertJql(
        endOfYear(),
        expectedJql = "endOfYear()"
    )

    @Test
    fun `endOfYear with an argument`() = assertJql(
        endOfYear(48.h.fromNow),
        expectedJql = """endOfYear("48h")"""
    )
}
