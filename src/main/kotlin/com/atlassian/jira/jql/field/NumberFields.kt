package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.Identifier

abstract class AbstractNumberField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: Long): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: Long): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<Long>): Clause = anyOf { values.map { it.toString() } }
    infix fun noneOf(values: Collection<Long>): Clause = noneOf { values.map { it.toString() } }
    infix fun greaterThan(value: Identifier): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: Identifier): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = lessThanOrEqualTo { value.toString() }
}

object Votes : AbstractNumberField("votes")

object Watchers : AbstractNumberField("watchers")

object WorkRatio : AbstractNumberField("workRatio") {
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}
