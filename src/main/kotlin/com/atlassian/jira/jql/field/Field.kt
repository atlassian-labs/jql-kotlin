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

interface FieldName {
    val name: String
}

interface SortableField : FieldName {
    val asc get() = FieldOrder.Ascending(name)
    val desc get() = FieldOrder.Descending(name)
}

abstract class Field(override val name: String) : FieldName {
    protected fun equalTo(valueProvider: () -> String) = clause(EQUALS, valueProvider())
    protected fun notEqualTo(valueProvider: () -> String) = clause(NOT_EQUALS, valueProvider())
    protected fun anyOf(valuesProvider: () -> Collection<String>) = clause(IN, valuesProvider())
    protected fun noneOf(valuesProvider: () -> Collection<String>) = clause(NOT_IN, valuesProvider())

    protected fun greaterThan(valueProvider: () -> String) = clause(GREATER_THAN, valueProvider())
    protected fun greaterThanOrEqualTo(valueProvider: () -> String) = clause(GREATER_THAN_EQUALS, valueProvider())
    protected fun lessThan(valueProvider: () -> String) = clause(LESS_THAN, valueProvider())
    protected fun lessThanOrEqualTo(valueProvider: () -> String) = clause(LESS_THAN_EQUALS, valueProvider())

    protected fun iz(valueProvider: () -> IsIsNotValue) = clause(IS, valueProvider())
    protected fun izNot(valueProvider: () -> IsIsNotValue) = clause(IS_NOT, valueProvider())

    protected fun contains(valueProvider: () -> String) = clause(CONTAINS, valueProvider())
    protected fun doesNotContain(valueProvider: () -> String) = clause(DOES_NOT_CONTAIN, valueProvider())

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

//
// object F : Field("kuku") {
//    infix fun equalTo(value: String) = equalTo { value }
//    infix fun iz(value: KeywordValue) = super.iz { value }
//    infix fun izNot(value: KeywordValue) = super.izNot { value }
// }
//
// fun main() {
//    val jql = F equalTo "hello" and -{ (F iz Empty) or -(F izNot Null) }
//    val j = -(F equalTo  "hello")
// }

// interface Field2 : JqlEntity {
//    val name: String
//    fun escapeValue(value: Any) = when (value) {
//        is String -> value.escape()
//        is Number -> value.toString()
//        else -> UnsupportedOperationException("Unsupported value type ${value::class.qualifiedName}")
//    }
//
//    operator fun unaryPlus() = FieldOrder.Ascending(this)
//    operator fun unaryMinus() = FieldOrder.Descending(this)
//    override fun toJql() = name
// }
