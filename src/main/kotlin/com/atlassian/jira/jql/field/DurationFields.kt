package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import java.time.Duration

internal fun Duration.toJql(): String = TODO("Not implemented yet")

abstract class AbstractDurationField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: Duration): Clause = equalTo { value.toJql() }
    infix fun notEqualTo(value: Duration): Clause = notEqualTo { value.toJql() }
    infix fun anyOf(values: Collection<Duration>): Clause = anyOf { values.map { it.toJql() } }
    infix fun noneOf(values: Collection<Duration>): Clause = noneOf { values.map { it.toJql() } }
    infix fun greaterThan(value: Duration): Clause = greaterThan { value.toJql() }
    infix fun greaterThanOrEqualTo(value: Duration): Clause = greaterThanOrEqualTo { value.toJql() }
    infix fun lessThan(value: Duration): Clause = lessThan { value.toJql() }
    infix fun lessThanOrEqualTo(value: Duration): Clause = lessThanOrEqualTo { value.toJql() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object OriginalEstimate : AbstractDurationField("originalEstimate")

object RemainingEstimate : AbstractDurationField("remainingEstimate")

object TimeSpent : AbstractDurationField("timeSpent")
