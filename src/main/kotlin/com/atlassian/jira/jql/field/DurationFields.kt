package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.RelativeDateTime

abstract class AbstractDurationField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: RelativeDateTime): Clause = equalTo { value.jql }
    infix fun notEqualTo(value: RelativeDateTime): Clause = notEqualTo { value.jql }
    infix fun anyOf(values: Collection<RelativeDateTime>): Clause = anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<RelativeDateTime>): Clause = noneOf { values.map { it.jql } }
    infix fun greaterThan(value: RelativeDateTime): Clause = greaterThan { value.jql }
    infix fun greaterThanOrEqualTo(value: RelativeDateTime): Clause = greaterThanOrEqualTo { value.jql }
    infix fun lessThan(value: RelativeDateTime): Clause = lessThan { value.jql }
    infix fun lessThanOrEqualTo(value: RelativeDateTime): Clause = lessThanOrEqualTo { value.jql }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object OriginalEstimate : AbstractDurationField("originalEstimate")

object RemainingEstimate : AbstractDurationField("remainingEstimate")

object TimeSpent : AbstractDurationField("timeSpent")
