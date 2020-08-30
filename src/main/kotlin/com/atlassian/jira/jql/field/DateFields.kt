package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.RelativeDate
import com.atlassian.jira.jql.RelativeDateTime
import com.atlassian.jira.jql.RelativeTemporal
import com.atlassian.jira.jql.escape
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
private val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

// Intentionally omitted EQUALS, NOT EQUALS, IN, NOT IN as they don't make much sense here
// given that they require minute precision timestamps equality.
abstract class AbstractDateField<T : Temporal, R : RelativeTemporal>(
    name: String,
    private val formatTemporal: (T) -> String = dateTimeFormat::format
) : Field(name), SortableField {
    infix fun greaterThan(value: T): Clause = greaterThan { formatTemporal(value).escape() }
    infix fun greaterThan(value: R): Clause = greaterThan { value.toJql() }
    infix fun greaterThanOrEqualTo(value: T): Clause = greaterThanOrEqualTo { formatTemporal(value).escape() }
    infix fun greaterThanOrEqualTo(value: R): Clause = greaterThanOrEqualTo { value.toJql() }
    infix fun lessThan(value: T): Clause = lessThan { formatTemporal(value).escape() }
    infix fun lessThan(value: R): Clause = lessThan { value.toJql() }
    infix fun lessThanOrEqualTo(value: T): Clause = lessThanOrEqualTo { formatTemporal(value).escape() }
    infix fun lessThanOrEqualTo(value: R): Clause = lessThanOrEqualTo { value.toJql() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Created : AbstractDateField<LocalDateTime, RelativeDateTime>("created")

object Due : AbstractDateField<LocalDate, RelativeDate>("due", dateFormat::format)

object LastViewed : AbstractDateField<LocalDateTime, RelativeDateTime>("lastViewed")

object Resolved : AbstractDateField<LocalDateTime, RelativeDateTime>("resolved")

object Updated : AbstractDateField<LocalDateTime, RelativeDateTime>("updated")
