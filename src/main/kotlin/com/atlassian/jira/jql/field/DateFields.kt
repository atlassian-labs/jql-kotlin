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
    infix fun greaterThan(value: T): Clause = _greaterThan { renderTemporal(value) }
    infix fun greaterThan(value: RelativeDateTime): Clause = _greaterThan { value.jql }
    infix fun greaterThan(function: DateFunction): Clause = _greaterThan(function)
    infix fun greaterThanOrEqualTo(value: T): Clause = _greaterThanOrEqualTo { renderTemporal(value) }
    infix fun greaterThanOrEqualTo(value: RelativeDateTime): Clause = _greaterThanOrEqualTo { value.jql }
    infix fun greaterThanOrEqualTo(function: DateFunction): Clause = _greaterThanOrEqualTo(function)
    infix fun lessThan(value: T): Clause = _lessThan { renderTemporal(value) }
    infix fun lessThan(value: RelativeDateTime): Clause = _lessThan { value.jql }
    infix fun lessThan(function: DateFunction): Clause = _lessThan(function)
    infix fun lessThanOrEqualTo(value: T): Clause = _lessThanOrEqualTo { renderTemporal(value) }
    infix fun lessThanOrEqualTo(value: RelativeDateTime): Clause = _lessThanOrEqualTo { value.jql }
    infix fun lessThanOrEqualTo(function: DateFunction): Clause = _lessThanOrEqualTo(function)
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }

    protected fun renderTemporal(value: T) = formatTemporal(value).escape()
}

object Created : AbstractDateField<LocalDateTime>("created")

// Unlike other date fields, EQUALS, NOT EQUALS, IN, NOT IN make sense for Due date.
// Omitted IN and NOT IN for relative date time arguments to avoid dealing with conflicting overloads.
object Due : AbstractDateField<LocalDate>("due", date::format) {
    infix fun equalTo(value: LocalDate): Clause = _equalTo { renderTemporal(value) }
    infix fun equalTo(value: RelativeDateTime): Clause = _equalTo { value.jql }
    infix fun equalTo(function: DateFunction): Clause = _equalTo(function)
    infix fun notEqualTo(value: LocalDate): Clause = _notEqualTo { renderTemporal(value) }
    infix fun notEqualTo(value: RelativeDateTime): Clause = _notEqualTo { value.jql }
    infix fun notEqualTo(function: DateFunction): Clause = _notEqualTo(function)
    infix fun anyOf(values: Collection<LocalDate>): Clause = _anyOf { values.map { renderTemporal(it) } }
    infix fun noneOf(values: Collection<LocalDate>): Clause = _noneOf { values.map { renderTemporal(it) } }
}

object LastViewed : AbstractDateField<LocalDateTime>("lastViewed")

object RequestLastActivityTime : AbstractDateField<LocalDateTime>("request-last-activity-time")

object Resolved : AbstractDateField<LocalDateTime>("resolved")

object Updated : AbstractDateField<LocalDateTime>("updated")
