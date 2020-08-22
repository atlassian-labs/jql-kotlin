package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
private val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

// Intentionally omitted EQUALS, NOT EQUALS, IN, NOT IN as they don't make much sense here
// given that they require minute precision timestamps equality.
abstract class AbstractDateField<T : Temporal>(
    name: String,
    private val formatTemporal: (T) -> String = dateTimeFormat::format
) : Field(name), SortableField {
    infix fun greaterThan(value: T): Clause = greaterThan { formatTemporal(value) }
    infix fun greaterThan(value: Duration): Clause = greaterThan { value.toJql() }
    infix fun greaterThanOrEqualTo(value: T): Clause = greaterThanOrEqualTo { formatTemporal(value) }
    infix fun greaterThanOrEqualTo(value: Duration): Clause = greaterThanOrEqualTo { value.toJql() }
    infix fun lessThan(value: T): Clause = lessThan { formatTemporal(value) }
    infix fun lessThan(value: Duration): Clause = lessThan { value.toJql() }
    infix fun lessThanOrEqualTo(value: T): Clause = lessThanOrEqualTo { formatTemporal(value) }
    infix fun lessThanOrEqualTo(value: Duration): Clause = lessThanOrEqualTo { value.toJql() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Created : AbstractDateField<LocalDateTime>("created")

object Due : AbstractDateField<LocalDate>("due", dateFormat::format)

object LastViewed : AbstractDateField<LocalDateTime>("lastViewed")

object Resolved : AbstractDateField<LocalDateTime>("resolved")

object Updated : AbstractDateField<LocalDateTime>("updated")
