package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.JqlEntity
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.field.Identifiers

interface VersionEqualityFunction : JqlEntity
interface VersionInclusionFunction : JqlEntity

fun latestReleasedVersion(vararg projects: String): VersionEqualityFunction =
    object : Function("latestReleasedVersion", projects.toList().map { it.escape() }), VersionEqualityFunction {}

fun latestReleasedVersion(projectIds: Identifiers): VersionEqualityFunction =
    object : Function("latestReleasedVersion", projectIds.identifiers.map { it.toString() }), VersionEqualityFunction {}

fun earliestUnreleasedVersion(vararg projects: String): VersionEqualityFunction =
    object : Function("earliestUnreleasedVersion", projects.toList().map { it.escape() }), VersionEqualityFunction {}

fun earliestUnreleasedVersion(projectIds: Identifiers): VersionEqualityFunction =
    object : Function("earliestUnreleasedVersion", projectIds.identifiers.map { it.toString() }), VersionEqualityFunction {}
