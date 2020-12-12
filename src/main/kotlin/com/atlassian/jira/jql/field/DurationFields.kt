package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.time.Duration

abstract class AbstractDurationField(name: String, vararg alias: String) : Field(name, *alias), SortableField {
    infix fun equalTo(value: Duration): Clause = _equalTo { value.jql }
    infix fun notEqualTo(value: Duration): Clause = _notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Duration>): Clause = _anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Duration>): Clause = _noneOf { values.map { it.jql } }
    infix fun greaterThan(value: Duration): Clause = _greaterThan { value.jql }
    infix fun greaterThanOrEqualTo(value: Duration): Clause = _greaterThanOrEqualTo { value.jql }
    infix fun lessThan(value: Duration): Clause = _lessThan { value.jql }
    infix fun lessThanOrEqualTo(value: Duration): Clause = _lessThanOrEqualTo { value.jql }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object OriginalEstimate : AbstractDurationField("originalEstimate", "timeOriginalEstimate")

object RemainingEstimate : AbstractDurationField("remainingEstimate", "timeEstimate")

object TimeSpent : AbstractDurationField("timeSpent")
