package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.field.Identifiers

interface VersionEqualityFunction : Function
interface VersionInclusionFunction : Function

fun latestReleasedVersion(vararg projects: String): VersionEqualityFunction = latestReleasedVersion(projects.toList())

fun latestReleasedVersion(projects: Collection<String>): VersionEqualityFunction =
    object : AbstractFunction("latestReleasedVersion", projects.map { it.escape() }), VersionEqualityFunction {}

fun latestReleasedVersion(projectIds: Identifiers): VersionEqualityFunction =
    object : AbstractFunction("latestReleasedVersion", projectIds.identifiers.map { it.toString() }), VersionEqualityFunction {}

fun earliestUnreleasedVersion(vararg projects: String): VersionEqualityFunction = earliestUnreleasedVersion(projects.toList())

fun earliestUnreleasedVersion(projects: Collection<String>): VersionEqualityFunction =
    object : AbstractFunction("earliestUnreleasedVersion", projects.map { it.escape() }), VersionEqualityFunction {}

fun earliestUnreleasedVersion(projectIds: Identifiers): VersionEqualityFunction =
    object : AbstractFunction("earliestUnreleasedVersion", projectIds.identifiers.map { it.toString() }), VersionEqualityFunction {}

fun releasedVersions(vararg projects: String): VersionInclusionFunction = releasedVersions(projects.toList())

fun releasedVersions(projects: Collection<String>): VersionInclusionFunction =
    object : AbstractFunction("releasedVersions", projects.map { it.escape() }), VersionInclusionFunction {}

fun releasedVersions(projectIds: Identifiers): VersionInclusionFunction =
    object : AbstractFunction("releasedVersions", projectIds.identifiers.map { it.toString() }), VersionInclusionFunction {}

fun unreleasedVersions(vararg projects: String): VersionInclusionFunction = unreleasedVersions(projects.toList())

fun unreleasedVersions(projects: Collection<String>): VersionInclusionFunction =
    object : AbstractFunction("unreleasedVersions", projects.map { it.escape() }), VersionInclusionFunction {}

fun unreleasedVersions(projectIds: Identifiers): VersionInclusionFunction =
    object : AbstractFunction("unreleasedVersions", projectIds.identifiers.map { it.toString() }), VersionInclusionFunction {}
