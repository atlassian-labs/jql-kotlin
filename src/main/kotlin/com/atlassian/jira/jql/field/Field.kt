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

interface FieldName {
    val name: String
}

interface SortableField : FieldName {
    val asc get() = FieldOrder.Ascending(name)
    val desc get() = FieldOrder.Descending(name)
}

@Suppress("FunctionName") // intentionally prefix internal functions with underscore
abstract class Field(override val name: String) : FieldName {
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
}
