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
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Approvals : Field("approvals") {
    infix fun equalTo(function: ApprovalsFunction): Clause = super.equalTo(function)
}

object Category : Field("category") {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object ChangeControlType : Field("change-control-type") {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Component : Field("component"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: ComponentFunction): Clause = super.anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: ComponentFunction): Clause = super.noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object CustomerRequestType : Field("\"Customer Request Type\"") {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
}

object EpicLink : Field("\"epic link\""), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: IssueFunction): Clause = super.anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: IssueFunction): Clause = super.noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Filter : Field("filter") {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
}

object IssueKey : Field("issueKey"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: IssueFunction): Clause = super.anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: IssueFunction): Clause = super.noneOf(function)
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = lessThanOrEqualTo { value.toString() }
}

object Labels : Field("labels"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Level : Field("level"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Organization : Field("organizations") {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
}

object Parent : Field("parent"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
}

object Priority : Field("priority"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Project : Field("project"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: ProjectFunction): Clause = super.anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: ProjectFunction): Clause = super.noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object ProjectType : Field("projectType") {
    infix fun equalTo(value: Value): Clause = equalTo { value.jql }
    infix fun notEqualTo(value: Value): Clause = notEqualTo { value.jql }
    infix fun anyOf(values: Collection<Value>): Clause = anyOf { values.map { it.jql } }
    infix fun noneOf(values: Collection<Value>): Clause = noneOf { values.map { it.jql } }

    sealed class Value(val jql: String) {
        object JiraCore : Value("business")
        object JiraSoftware : Value("software")
        object JiraServiceDesk : Value("service_desk")
        object JiraOps : Value("ops")
    }
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

object Resolution : Field("resolution"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Sprint : Field("sprint"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: SprintFunction): Clause = super.anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: SprintFunction): Clause = super.noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Status : Field("status"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Type : Field("type"), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}
