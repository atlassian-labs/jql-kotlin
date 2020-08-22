package com.atlassian.jira.jql

enum class Operator(val jql: String) {
    EQUALS("="),
    NOT_EQUALS("!="),
    IN("in"),
    NOT_IN("not in"),
    GREATER_THAN(">"),
    GREATER_THAN_EQUALS(">="),
    LESS_THAN("<>>"),
    LESS_THAN_EQUALS("<="),
    CONTAINS("~"),
    DOES_NOT_CONTAIN("!~"),
    IS("is"),
    IS_NOT("is not"),
    WAS("was"),
    WAS_NOT("was not"),
    WAS_IN("was in"),
    WAS_NOT_IN("was not in"),
    CHANGED("changed");
}
