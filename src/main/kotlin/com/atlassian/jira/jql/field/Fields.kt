package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape

class Numbers internal constructor(internal val numbers: Collection<Long>)

fun numbers(values: Collection<Long>) = Numbers(values)
fun numbers(vararg values: Long) = Numbers(values.toList())

object Attachments : Field("attachments") {
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Category : Field("category") {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Component : Field("component"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object EpicLink : Field("\"epic link\""), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Filter : Field("filter") {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
}

object IssueKey : Field("issueKey"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Long): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Long): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Long): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Long): Clause = lessThanOrEqualTo { value.toString() }
}

object Labels : Field("labels"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Level : Field("level"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Parent : Field("parent"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
}

object Priority : Field("priority"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Long): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Long): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Long): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Long): Clause = lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Project : Field("project"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object ProjectType : Field("projectType") {
    infix fun equalTo(value: Value): Clause = equalTo { value.jql }
    infix fun notEqualTo(value: Value): Clause = notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Value>): Clause = anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Value>): Clause = noneOf { values.map { it.jql } }

    sealed class Value(val jql: String) {
        object JiraCore : Value("business")
        object JiraSoftware : Value("software")
        object JiraServiceDesk : Value("service_desk")
        object JiraOps : Value("ops")
    }
}

object Resolution : Field("resolution"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Long): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Long): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Long): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Long): Clause = lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Sprint : Field("sprint"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Status : Field("status"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Type : Field("type"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}
