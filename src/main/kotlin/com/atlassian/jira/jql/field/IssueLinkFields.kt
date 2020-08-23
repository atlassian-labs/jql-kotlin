package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape

abstract class AbstractIssueLinkField(type: IssueLinkType.Name? = null) : Field(
    type?.let { "issue${it.jql}" } ?: "issueLink"
) {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Number): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Number): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
}

object IssueLink : AbstractIssueLinkField() {
    fun ofType(type: IssueLinkType.Name) = object : AbstractIssueLinkField(type) {}
}

object IssueLinkType : Field("issueLinkType") {
    infix fun equalTo(value: Name): Clause = equalTo { value.jql }
    infix fun notEqualTo(value: Name): Clause = notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Name>): Clause = anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Name>): Clause = noneOf { values.map { it.jql } }

    class Name(val jql: String)

    val isBlockedBy = Name("IsBlockedBy")
    val blocks = Name("Blocks")
    val isClonedBy = Name("IsClonedBy")
    val clones = Name("Clones")
    val isDuplicatedBy = Name("IsDuplicatedBy")
    val duplicates = Name("Duplicates")
    val splitFrom = Name("SplitFrom")
    val splitTo = Name("SplitTo")
    val isCausedBy = Name("IsCausedBy")
    val causes = Name("Causes")

    fun custom(jql: String) = Name(jql)
}
