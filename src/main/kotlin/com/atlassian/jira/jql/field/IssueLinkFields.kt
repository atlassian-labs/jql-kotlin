package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.Identifier
import com.atlassian.jira.jql.escape
import java.util.Locale

abstract class AbstractIssueLinkField(type: IssueLinkType.Value? = null) : Field(
    type?.let { "issue${it.issueLinkSuffix}" } ?: "issueLink"
) {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
}

object IssueLink : AbstractIssueLinkField() {
    fun ofType(type: IssueLinkType.Value) = object : AbstractIssueLinkField(type) {}
}

object IssueLinkType : Field("issueLinkType") {
    infix fun equalTo(value: Value): Clause = _equalTo { value.jql }
    infix fun notEqualTo(value: Value): Clause = _notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Value>): Clause = _anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Value>): Clause = _noneOf { values.map { it.jql } }

    class Value(val jql: String) {
        val issueLinkSuffix: String
            get() = jql
                .removePrefix("\"")
                .removeSuffix("\"")
                .split(' ')
                .joinToString(separator = "") {
                    it.replaceFirstChar { ch -> if (ch.isLowerCase()) ch.titlecase(Locale.ENGLISH) else it }
                }
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
