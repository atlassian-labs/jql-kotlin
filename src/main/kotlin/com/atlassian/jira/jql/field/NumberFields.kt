package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.Identifier

abstract class AbstractNumberField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: Long): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: Long): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<Long>): Clause = _anyOf { values.map { it.toString() } }
    infix fun noneOf(values: Collection<Long>): Clause = _noneOf { values.map { it.toString() } }
    infix fun greaterThan(value: Identifier): Clause = _greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = _greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: Identifier): Clause = _lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = _lessThanOrEqualTo { value.toString() }
}

object Votes : AbstractNumberField("votes")

object Watchers : AbstractNumberField("watchers")

object WorkRatio : AbstractNumberField("workRatio") {
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}
