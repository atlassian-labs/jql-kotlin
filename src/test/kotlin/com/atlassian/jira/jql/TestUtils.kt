package com.atlassian.jira.jql

import org.junit.jupiter.api.Assertions.assertEquals

fun assertJql(actualJql: JqlEntity, expectedJql: String) = assertJql(actualJql.toJql(), expectedJql)
fun assertJql(actualJql: String, expectedJql: String) = assertEquals(expectedJql.trim(), actualJql)
