package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.TemporalFormatter.date
import com.atlassian.jira.jql.TemporalFormatter.dateTime
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.function.DateFunction
import com.atlassian.jira.jql.time.RelativeDateTime
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.Temporal

// Intentionally omitted EQUALS, NOT EQUALS, IN, NOT IN as they don't make much sense here
// given that they require minute precision timestamps equality.
abstract class AbstractDateField<T : Temporal>(
    name: String,
    private val formatTemporal: (T) -> String = dateTime::format,
) : Field(name), SortableField {
    infix fun greaterThan(value: T): Clause = greaterThan { renderTemporal(value) }
    infix fun greaterThan(value: RelativeDateTime): Clause = greaterThan { value.jql }
    infix fun greaterThan(function: DateFunction): Clause = super.greaterThan(function)
    infix fun greaterThanOrEqualTo(value: T): Clause = greaterThanOrEqualTo { renderTemporal(value) }
    infix fun greaterThanOrEqualTo(value: RelativeDateTime): Clause = greaterThanOrEqualTo { value.jql }
    infix fun greaterThanOrEqualTo(function: DateFunction): Clause = super.greaterThanOrEqualTo(function)
    infix fun lessThan(value: T): Clause = lessThan { renderTemporal(value) }
    infix fun lessThan(value: RelativeDateTime): Clause = lessThan { value.jql }
    infix fun lessThan(function: DateFunction): Clause = super.lessThan(function)
    infix fun lessThanOrEqualTo(value: T): Clause = lessThanOrEqualTo { renderTemporal(value) }
    infix fun lessThanOrEqualTo(value: RelativeDateTime): Clause = lessThanOrEqualTo { value.jql }
    infix fun lessThanOrEqualTo(function: DateFunction): Clause = super.lessThanOrEqualTo(function)
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }

    protected fun renderTemporal(value: T) = formatTemporal(value).escape()
}

object Created : AbstractDateField<LocalDateTime>("created")

// Unlike other date fields, EQUALS, NOT EQUALS, IN, NOT IN make sense for Due date.
// Omitted IN and NOT IN for relative date time arguments to avoid dealing with conflicting overloads.
object Due : AbstractDateField<LocalDate>("due", date::format) {
    infix fun equalTo(value: LocalDate): Clause = equalTo { renderTemporal(value) }
    infix fun equalTo(value: RelativeDateTime): Clause = equalTo { value.jql }
    infix fun equalTo(function: DateFunction): Clause = super.equalTo(function)
    infix fun notEqualTo(value: LocalDate): Clause = notEqualTo { renderTemporal(value) }
    infix fun notEqualTo(value: RelativeDateTime): Clause = notEqualTo { value.jql }
    infix fun notEqualTo(function: DateFunction): Clause = super.notEqualTo(function)
    infix fun anyOf(values: Collection<LocalDate>): Clause = anyOf { values.map { renderTemporal(it) } }
    infix fun noneOf(values: Collection<LocalDate>): Clause = noneOf { values.map { renderTemporal(it) } }
}

object LastViewed : AbstractDateField<LocalDateTime>("lastViewed")

object RequestLastActivityTime : AbstractDateField<LocalDateTime>("request-last-activity-time")

object Resolved : AbstractDateField<LocalDateTime>("resolved")

object Updated : AbstractDateField<LocalDateTime>("updated")
