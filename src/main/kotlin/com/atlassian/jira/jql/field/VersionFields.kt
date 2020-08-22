package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape

abstract class AbstractVersionField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Number): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Number): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Number): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Number): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Number): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Number): Clause = lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object AffectedVersion : AbstractVersionField("affectedVersion")

object FixVersion : AbstractVersionField("fixVersion")
