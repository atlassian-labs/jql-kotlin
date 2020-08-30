package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.RelativeDateTime

abstract class AbstractDurationField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: RelativeDateTime): Clause = equalTo { value.toJql() }
    infix fun notEqualTo(value: RelativeDateTime): Clause = notEqualTo { value.toJql() }
    infix fun anyOf(values: Collection<RelativeDateTime>): Clause = anyOf { values.map { it.toJql() } }
    infix fun noneOf(values: Collection<RelativeDateTime>): Clause = noneOf { values.map { it.toJql() } }
    infix fun greaterThan(value: RelativeDateTime): Clause = greaterThan { value.toJql() }
    infix fun greaterThanOrEqualTo(value: RelativeDateTime): Clause = greaterThanOrEqualTo { value.toJql() }
    infix fun lessThan(value: RelativeDateTime): Clause = lessThan { value.toJql() }
    infix fun lessThanOrEqualTo(value: RelativeDateTime): Clause = lessThanOrEqualTo { value.toJql() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object OriginalEstimate : AbstractDurationField("originalEstimate")

object RemainingEstimate : AbstractDurationField("remainingEstimate")

object TimeSpent : AbstractDurationField("timeSpent")
