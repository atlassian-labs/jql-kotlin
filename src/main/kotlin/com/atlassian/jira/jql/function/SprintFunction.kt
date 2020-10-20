package com.atlassian.jira.jql.function

interface SprintFunction : Function

fun openSprints(): SprintFunction = object : AbstractFunction("openSprints"), SprintFunction {}
fun closedSprints(): SprintFunction = object : AbstractFunction("closedSprints"), SprintFunction {}
fun futureSprints(): SprintFunction = object : AbstractFunction("futureSprints"), SprintFunction {}
