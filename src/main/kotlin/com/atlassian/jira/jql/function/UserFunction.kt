package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.escape

interface UserEqualityFunction : Function
interface UserInclusionFunction : Function

fun currentUser(): UserEqualityFunction =
    object : AbstractFunction("currentUser"), UserEqualityFunction {}

fun membersOf(group: String): UserInclusionFunction =
    object : AbstractFunction("membersOf", listOf(group.escape())), UserInclusionFunction {}

fun organizationMembers(vararg organizations: String): UserInclusionFunction = organizationMembers(organizations.toList())
fun organizationMembers(organizations: Collection<String>): UserInclusionFunction =
    object : AbstractFunction("membersOf", organizations.requireAtLeastOneArgument().map { it.escape() }), UserInclusionFunction {}
