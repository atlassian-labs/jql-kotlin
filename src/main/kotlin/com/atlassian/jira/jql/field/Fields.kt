package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.Identifier
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.function.ApprovalsFunction
import com.atlassian.jira.jql.function.ComponentFunction
import com.atlassian.jira.jql.function.IssueFunction
import com.atlassian.jira.jql.function.ProjectFunction
import com.atlassian.jira.jql.function.SprintFunction

class Identifiers internal constructor(internal val identifiers: Collection<Identifier>)

fun ids(values: Collection<Identifier>) = Identifiers(values)
fun ids(vararg values: Identifier) = Identifiers(values.toList())

object Attachments : Field("attachments") {
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Approvals : Field("approvals") {
    infix fun equalTo(function: ApprovalsFunction): Clause = _equalTo(function)
}

object Category : Field("category") {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object ChangeControlType : Field("change-control-type") {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Component : Field("component"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: ComponentFunction): Clause = _anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: ComponentFunction): Clause = _noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object CustomerRequestType : Field("\"Customer Request Type\"") {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
}

object EpicLink : Field("\"epic link\""), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: IssueFunction): Clause = _anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: IssueFunction): Clause = _noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Filter : Field("filter") {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
}

object IssueKey : Field("issueKey"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: IssueFunction): Clause = _anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: IssueFunction): Clause = _noneOf(function)
    infix fun greaterThan(value: String): Clause = _greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = _greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = _greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = _greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = _lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = _lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = _lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = _lessThanOrEqualTo { value.toString() }
}

object Labels : Field("labels"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Level : Field("level"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Organization : Field("organizations") {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
}

object Parent : Field("parent"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
}

object Priority : Field("priority"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = _greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = _greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = _greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = _greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = _lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = _lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = _lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = _lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Project : Field("project"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: ProjectFunction): Clause = _anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: ProjectFunction): Clause = _noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object ProjectType : Field("projectType") {
    infix fun equalTo(value: Value): Clause = _equalTo { value.jql }
    infix fun notEqualTo(value: Value): Clause = _notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Value>): Clause = _anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Value>): Clause = _noneOf { values.map { it.jql } }

    sealed class Value(val jql: String) {
        object JiraCore : Value("business")
        object JiraSoftware : Value("software")
        object JiraServiceDesk : Value("service_desk")
        object JiraOps : Value("ops")
    }
}

object RequestChannelType : Field("request-channel-type") {
    infix fun equalTo(value: Value): Clause = _equalTo { value.jql }
    infix fun notEqualTo(value: Value): Clause = _notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Value>): Clause = _anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Value>): Clause = _noneOf { values.map { it.jql } }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }

    class Value(val jql: String)

    val email = Value("email")
    val jira = Value("jira")
    val portal = Value("portal")
    val anonymousPortal = Value("\"anonymous portal\"")
    val api = Value("api")
}

object Resolution : Field("resolution"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = _greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = _greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = _greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = _greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = _lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = _lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = _lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = _lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Sprint : Field("sprint"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: SprintFunction): Clause = _anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: SprintFunction): Clause = _noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Status : Field("status"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Type : Field("type"), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}
