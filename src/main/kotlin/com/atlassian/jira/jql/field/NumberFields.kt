package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause

abstract class AbstractNumberField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: Number): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: Number): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Numbers): Clause = anyOf { values.numbers.map { it.toString() } }
    infix fun noneOf(values: Numbers): Clause = noneOf { values.numbers.map { it.toString() } }
    infix fun greaterThan(value: Number): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: Number): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: Number): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: Number): Clause = lessThanOrEqualTo { value.toString() }
}

object Votes : AbstractNumberField("votes")

object Watchers : AbstractNumberField("watchers")

object WorkRatio : AbstractNumberField("workRatio") {
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}
