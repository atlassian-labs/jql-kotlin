package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.time.Duration

abstract class AbstractDurationField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: Duration): Clause = equalTo { value.jql }
    infix fun notEqualTo(value: Duration): Clause = notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Duration>): Clause = anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Duration>): Clause = noneOf { values.map { it.jql } }
    infix fun greaterThan(value: Duration): Clause = greaterThan { value.jql }
    infix fun greaterThanOrEqualTo(value: Duration): Clause = greaterThanOrEqualTo { value.jql }
    infix fun lessThan(value: Duration): Clause = lessThan { value.jql }
    infix fun lessThanOrEqualTo(value: Duration): Clause = lessThanOrEqualTo { value.jql }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object OriginalEstimate : AbstractDurationField("originalEstimate")

object RemainingEstimate : AbstractDurationField("remainingEstimate")

object TimeSpent : AbstractDurationField("timeSpent")
