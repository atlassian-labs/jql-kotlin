package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.Identifier
import com.atlassian.jira.jql.escape
import java.util.Locale

abstract class AbstractIssueLinkField(type: IssueLinkType.Value? = null) : Field(
    type?.let { "issue${it.issueLinkSuffix}" } ?: "issueLink"
) {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
}

object IssueLink : AbstractIssueLinkField() {
    fun ofType(type: IssueLinkType.Value) = object : AbstractIssueLinkField(type) {}
}

object IssueLinkType : Field("issueLinkType") {
    infix fun equalTo(value: Value): Clause = equalTo { value.jql }
    infix fun notEqualTo(value: Value): Clause = notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Value>): Clause = anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Value>): Clause = noneOf { values.map { it.jql } }

    class Value(val jql: String) {
        val issueLinkSuffix: String
            get() = jql
                .removePrefix("\"")
                .removeSuffix("\"")
                .split(' ')
                .joinToString(separator = "") { it.capitalize(Locale.ENGLISH) }
    }

    val isBlockedBy = Value("\"is blocked by\"")
    val blocks = Value("blocks")
    val isClonedBy = Value("\"is cloned by\"")
    val clones = Value("clones")
    val isDuplicatedBy = Value("\"is duplicated by\"")
    val duplicates = Value("duplicates")
    val splitFrom = Value("\"split from\"")
    val splitTo = Value("\"split to\"")
    val isCausedBy = Value("\"is caused by\"")
    val causes = Value("causes")

    fun custom(jql: String) = Value(jql)
}
