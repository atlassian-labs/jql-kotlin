package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.function.SlaComparativeFunction
import com.atlassian.jira.jql.function.SlaEqualityFunction
import com.atlassian.jira.jql.time.RelativeTime

// Intentionally omitted EQUALS, NOT EQUALS with relative time argument as they don't make much sense here
// given that they require minute precision values equality.
abstract class AbstractSlaField(name: String) : Field(name), SortableField {
    infix fun equalTo(function: SlaEqualityFunction) = _equalTo(function)
    infix fun notEqualTo(function: SlaEqualityFunction): Clause = _notEqualTo(function)
    infix fun greaterThan(value: RelativeTime): Clause = _greaterThan { value.jql }
    infix fun greaterThan(function: SlaComparativeFunction): Clause = _greaterThan(function)
    infix fun greaterThanOrEqualTo(value: RelativeTime): Clause = _greaterThanOrEqualTo { value.jql }
    infix fun greaterThanOrEqualTo(function: SlaComparativeFunction): Clause = _greaterThanOrEqualTo(function)
    infix fun lessThan(value: RelativeTime): Clause = _lessThan { value.jql }
    infix fun lessThan(function: SlaComparativeFunction): Clause = _lessThan(function)
    infix fun lessThanOrEqualTo(value: RelativeTime): Clause = _lessThanOrEqualTo { value.jql }
    infix fun lessThanOrEqualTo(function: SlaComparativeFunction): Clause = _lessThanOrEqualTo(function)
}

object Sla {
    object TimeToResolution : AbstractSlaField("\"Time to resolution\"")

    object TimeToFirstResponse : AbstractSlaField("\"Time to first response\"")

    fun custom(jql: String) = object : AbstractSlaField(jql) {}
}
