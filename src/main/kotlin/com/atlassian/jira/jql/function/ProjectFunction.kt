package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.escape

interface ProjectFunction : Function

fun projectsLeadByUser(user: String? = null): ProjectFunction =
    object : AbstractFunction("projectsLeadByUser", listOfNotNull(user).map { it.escape() }), ProjectFunction {}

fun projectsWhereUserHasPermission(permission: String): ProjectFunction =
    object : AbstractFunction("projectsWhereUserHasPermission", listOf(permission.escape())), ProjectFunction {}

fun projectsWhereUserHasRole(role: String): ProjectFunction =
    object : AbstractFunction("projectsWhereUserHasRole", listOf(role.escape())), ProjectFunction {}
