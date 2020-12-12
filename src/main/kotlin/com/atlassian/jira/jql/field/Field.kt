package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.FieldOrder
import com.atlassian.jira.jql.Operator
import com.atlassian.jira.jql.Operator.CONTAINS
import com.atlassian.jira.jql.Operator.DOES_NOT_CONTAIN
import com.atlassian.jira.jql.Operator.EQUALS
import com.atlassian.jira.jql.Operator.GREATER_THAN
import com.atlassian.jira.jql.Operator.GREATER_THAN_EQUALS
import com.atlassian.jira.jql.Operator.IN
import com.atlassian.jira.jql.Operator.IS
import com.atlassian.jira.jql.Operator.IS_NOT
import com.atlassian.jira.jql.Operator.LESS_THAN
import com.atlassian.jira.jql.Operator.LESS_THAN_EQUALS
import com.atlassian.jira.jql.Operator.NOT_EQUALS
import com.atlassian.jira.jql.Operator.NOT_IN
import com.atlassian.jira.jql.function.Function
import java.util.Locale

interface NamedField {
    val name: String
    val aliases: Collection<String>
}

interface SortableField : NamedField {
    val asc get() = FieldOrder.Ascending(this)
    val desc get() = FieldOrder.Descending(this)

    companion object {
        // TODO test for sortable fields
        fun forName(name: String): SortableField? =
            when (val field = FieldMap.lookup(name)) {
                is SortableField -> field
                else -> null
            }
    }
}

@Suppress("FunctionName") // intentionally prefix internal functions with underscore
abstract class Field(override val name: String, override val aliases: Collection<String>) : NamedField {
    constructor(name: String, vararg alias: String) : this(name, alias.asList())

    protected fun _equalTo(valueProvider: () -> String) = clause(EQUALS, valueProvider())
    protected fun _equalTo(function: Function) = clause(EQUALS, function.toJql())
    protected fun _notEqualTo(valueProvider: () -> String) = clause(NOT_EQUALS, valueProvider())
    protected fun _notEqualTo(function: Function) = clause(NOT_EQUALS, function.toJql())
    protected fun _anyOf(valuesProvider: () -> Collection<String>) = clause(IN, valuesProvider())
    protected fun _anyOf(function: Function) = clause(IN, function.toJql())
    protected fun _noneOf(valuesProvider: () -> Collection<String>) = clause(NOT_IN, valuesProvider())
    protected fun _noneOf(function: Function) = clause(NOT_IN, function.toJql())

    protected fun _greaterThan(valueProvider: () -> String) = clause(GREATER_THAN, valueProvider())
    protected fun _greaterThan(function: Function) = clause(GREATER_THAN, function.toJql())
    protected fun _greaterThanOrEqualTo(valueProvider: () -> String) = clause(GREATER_THAN_EQUALS, valueProvider())
    protected fun _greaterThanOrEqualTo(function: Function) = clause(GREATER_THAN_EQUALS, function.toJql())
    protected fun _lessThan(valueProvider: () -> String) = clause(LESS_THAN, valueProvider())
    protected fun _lessThan(function: Function) = clause(LESS_THAN, function.toJql())
    protected fun _lessThanOrEqualTo(valueProvider: () -> String) = clause(LESS_THAN_EQUALS, valueProvider())
    protected fun _lessThanOrEqualTo(function: Function) = clause(LESS_THAN_EQUALS, function.toJql())

    protected fun _iz(valueProvider: () -> IsIsNotValue) = clause(IS, valueProvider())
    protected fun _izNot(valueProvider: () -> IsIsNotValue) = clause(IS_NOT, valueProvider())

    protected fun _contains(valueProvider: () -> String) = clause(CONTAINS, valueProvider())
    protected fun _doesNotContain(valueProvider: () -> String) = clause(DOES_NOT_CONTAIN, valueProvider())

    private fun clause(operator: Operator, operand: String): Clause =
        operand.takeIf { it.isNotBlank() }
            ?.let { Clause("$name ${operator.jql} $it") }
            ?: Clause.empty()

    private fun clause(operator: Operator, operand: Collection<String>): Clause =
        operand.joinToString(separator = ",")
            // Empty list should result in an empty JQL string
            .takeIf { it.isNotBlank() }
            ?.let { clause(operator, "($it)") }
            ?: Clause.empty()

    private fun clause(operator: Operator, operand: IsIsNotValue): Clause =
        Clause("$name ${operator.jql} ${operand.jql}")

    companion object {
        fun forName(name: String): Field? = FieldMap.lookup(name)
    }
}

private object FieldMap {
    private val fieldsByName: Map<String, Field> by lazy {
        listOf(
            AffectedVersion,
            Approvals,
            Assignee,
            Attachments,
            Category,
            ChangeControlType,
            Comment,
            Component,
            Created,
            Creator,
            CustomerRequestType,
            Description,
            Due,
            Environment,
            EpicLink,
            Filter,
            FixVersion,
            IssueKey,
            IssueLink,
            IssueLinkType,
            Labels,
            LastViewed,
            Level,
            Organization,
            OriginalEstimate,
            Parent,
            Priority,
            Project,
            ProjectType,
            RemainingEstimate,
            Reporter,
            RequestChannelType,
            RequestLastActivityTime,
            Resolution,
            Resolved,
            Sprint,
            Status,
            StatusCategory,
            Summary,
            Text,
            TimeSpent,
            Sla.TimeToFirstResponse,
            Sla.TimeToResolution,
            Type,
            Updated,
            Voter,
            Votes,
            Watcher,
            Watchers,
            WorkRatio,
        )
            .flatMap { field -> (field.aliases + field.name).map { alias -> alias.normalize() to field } }
            .toMap()
    }

    fun lookup(name: String): Field? = fieldsByName[name.normalize()]

    private fun String.normalize() = toLowerCase(Locale.ENGLISH).removeSurrounding("\"")
}
