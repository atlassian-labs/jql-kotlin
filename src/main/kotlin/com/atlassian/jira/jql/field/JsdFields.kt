package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.RelativeDateTime
import com.atlassian.jira.jql.escape
import java.time.Duration
import java.time.LocalDateTime

object Jsd {
    object Approvals : Field("approvals") {
        val todo: Nothing = TODO("Only functions here")
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
        infix fun equalTo(value: Name): Clause = equalTo { value.jql }
        infix fun notEqualTo(value: Name): Clause = notEqualTo { value.jql }
        infix fun anyOf(values: Collection<Name>): Clause = anyOf { values.map { it.jql } }
        infix fun noneOf(values: Collection<Name>): Clause = noneOf { values.map { it.jql } }
        infix fun iz(value: IsIsNotValue): Clause = iz { value }
        infix fun izNot(value: IsIsNotValue): Clause = izNot { value }

        class Name(val jql: String)

        val email = Name("email")
        val jira = Name("jira")
        val portal = Name("portal")
        val anonymousPortal = Name("\"anonymous portal\"")
        val api = Name("api")
    }

    object RequestLastActivityTime : AbstractDateField<LocalDateTime, RelativeDateTime>("request-last-activity-time")

    abstract class AbstractSlaField(name: String) : Field(name) {
        infix fun equalTo(value: Duration): Clause = equalTo { value.toJql() }
        infix fun notEqualTo(value: Duration): Clause = notEqualTo { value.toJql() }
        infix fun anyOf(values: Collection<Duration>): Clause = anyOf { values.map { it.toJql() } }
        infix fun noneOf(values: Collection<Duration>): Clause = noneOf { values.map { it.toJql() } }
        infix fun greaterThan(value: Duration): Clause = greaterThan { value.toJql() }
        infix fun greaterThanOrEqualTo(value: Duration): Clause = greaterThanOrEqualTo { value.toJql() }
        infix fun lessThan(value: Duration): Clause = lessThan { value.toJql() }
        infix fun lessThanOrEqualTo(value: Duration): Clause = lessThanOrEqualTo { value.toJql() }
    }

    object SLA {
        object TimeToResolution : AbstractSlaField("\"Time to resolution\"")

        object TimeToFirstResponse : AbstractSlaField("\"Time to first response\"")

        fun custom(jql: String) = object : AbstractSlaField(jql) {}

        val todo: Nothing = TODO("Only functions here")
    }
}
