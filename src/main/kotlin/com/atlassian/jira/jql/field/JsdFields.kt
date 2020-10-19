package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.function.ApprovalsFunction
import com.atlassian.jira.jql.time.RelativeDateTime
import com.atlassian.jira.jql.time.RelativeTime
import java.time.LocalDateTime

object Jsd {
    object Approvals : Field("approvals") {
        infix fun equalTo(function: ApprovalsFunction): Clause = equalTo { function.toJql() }
    }

    object ChangeControlType : Field("change-control-type") {
        infix fun equalTo(value: String): Clause = equalTo { value.escape() }
        infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
        infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
        infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
        infix fun iz(value: IsIsNotValue): Clause = iz { value }
        infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
    }

    object CustomerRequestType : Field("\"Customer Request Type\"") {
        infix fun equalTo(value: String): Clause = equalTo { value.escape() }
        infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
        infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
        infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    }

    object Organization : Field("organizations") {
        infix fun equalTo(value: String): Clause = equalTo { value.escape() }
        infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
        infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
        infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    }

    object RequestChannelType : Field("request-channel-type") {
        infix fun equalTo(value: Value): Clause = equalTo { value.jql }
        infix fun notEqualTo(value: Value): Clause = notEqualTo { value.jql }
        infix fun anyOf(values: Collection<Value>): Clause = anyOf { values.map { it.jql } }
        infix fun noneOf(values: Collection<Value>): Clause = noneOf { values.map { it.jql } }
        infix fun iz(value: IsIsNotValue): Clause = iz { value }
        infix fun izNot(value: IsIsNotValue): Clause = izNot { value }

        class Value(val jql: String)

        val email = Value("email")
        val jira = Value("jira")
        val portal = Value("portal")
        val anonymousPortal = Value("\"anonymous portal\"")
        val api = Value("api")
    }

    object RequestLastActivityTime : AbstractDateField<LocalDateTime, RelativeDateTime>("request-last-activity-time")

    // Intentionally omitted EQUALS, NOT EQUALS as they don't make much sense here
    // given that they require minute precision values equality.
    abstract class AbstractSlaField(name: String) : Field(name), SortableField {
        infix fun greaterThan(value: RelativeTime): Clause = greaterThan { value.jql }
        infix fun greaterThanOrEqualTo(value: RelativeTime): Clause = greaterThanOrEqualTo { value.jql }
        infix fun lessThan(value: RelativeTime): Clause = lessThan { value.jql }
        infix fun lessThanOrEqualTo(value: RelativeTime): Clause = lessThanOrEqualTo { value.jql }
    }

    object Sla {
        object TimeToResolution : AbstractSlaField("\"Time to resolution\"")

        object TimeToFirstResponse : AbstractSlaField("\"Time to first response\"")

        fun custom(jql: String) = object : AbstractSlaField(jql) {}
    }
}
