package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape
import java.util.Locale

abstract class AbstractIssueLinkField(type: IssueLinkType.Name? = null) : Field(
    type?.let { "issue${it.issueLinkSuffix}" } ?: "issueLink"
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
    infix fun equalTo(value: Name): Clause = equalTo { value.value }
    infix fun notEqualTo(value: Name): Clause = notEqualTo { value.value }
    infix fun anyOf(values: Collection<Name>): Clause = anyOf { values.map { it.value } }
    infix fun noneOf(values: Collection<Name>): Clause = noneOf { values.map { it.value } }

    class Name(val value: String) {
        val issueLinkSuffix: String
            get() = value
                .removePrefix("\"")
                .removeSuffix("\"")
                .split(' ')
                .joinToString(separator = "") { it.capitalize(Locale.ENGLISH) }
    }

    val isBlockedBy = Name("\"is blocked by\"")
    val blocks = Name("blocks")
    val isClonedBy = Name("\"is cloned by\"")
    val clones = Name("clones")
    val isDuplicatedBy = Name("\"is duplicated by\"")
    val duplicates = Name("duplicates")
    val splitFrom = Name("\"split from\"")
    val splitTo = Name("\"split to\"")
    val isCausedBy = Name("\"is caused by\"")
    val causes = Name("causes")

    fun custom(jql: String) = Name(jql)
}
