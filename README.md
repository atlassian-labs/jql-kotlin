jql-kotlin
==========

Kotlin DSL for generating queries in [Jira Query Language (JQL)](https://support.atlassian.com/jira-software-cloud/docs/use-advanced-search-with-jira-query-language-jql/).

```kotlin
val jqlQuery: String = Project anyOf listOf("JIRA", "JQL") and { Labels equalTo "jql" or (Component equalTo "JQL") } and (Created greaterThanOrEqualTo 4.weeks.ago) orderBy Assignee.asc

println(jqlQuery)  // project in ("JIRA","JQL") AND (labels = "jql" OR component = "JQL") AND created >= "-4w" ORDER BY assignee ASC
```

## Features

- JQL query expressed as Kotlin code which looks close to the actual query it generates
- Type safety guaranteed by Kotlin compiler
- Definitions for standard Jira [fields](https://support.atlassian.com/jira-software-cloud/docs/advanced-search-reference-jql-fields/)
  with applicable [operations](https://support.atlassian.com/jira-software-cloud/docs/advanced-search-reference-jql-operators/),
  including [functions](https://support.atlassian.com/jira-software-cloud/docs/advanced-search-reference-jql-functions/)
- Extendable with custom fields, issue link types, etc.
- User input sanitization
- Mini DSL for duration and relative time values

## Installation

### Maven

```xml
<dependency>
    <groupId>com.atlassian.jira</groupId>
    <artifactId>jql-kotlin</artifactId>
    <version>0.2</version>
</dependency>
```

### Gradle

```groovy
dependencies {
   implementation 'com.atlassian.jira:jql-kotlin:0.2'
}
```

## Usage

JQL Kotlin DSL is designed to resemble the query it generates as much as possible.

### Fields

Jira [fields](https://support.atlassian.com/jira-software-cloud/docs/advanced-search-reference-jql-fields/)
are represented as Kotlin objects in `com.atlassian.jira.jql.field` package, so they have names in camel case,
e.g. `IssueKey`, `Project`, `Status`, etc.

Each standard field defines all operators which are applicable to that field.

Some fields support `String` values as well as numeric identifiers, – such fields in the DSL provide overloads for
both cases. Note that unlike the real JQL, a mix of identifiers and literal values in a single list (e.g. passed to
`in`/`not in` operator) is not supported.

Date and duration fields (e.g. `Created` and `OriginalEstimate`, respectively) allow only relevant types as arguments
of applicable operators.

### Operators

[Operators](https://support.atlassian.com/jira-software-cloud/docs/advanced-search-reference-jql-operators/) are defined
as infix member functions of fields. This allows omitting dots and parentheses.

Since some symbols and literals can't be used in Kotlin function name directly, they are replaced with a close
text representation, e.g. operator `>=` is expressed as `greaterThanOrEqualTo` function, as well as `IS` operator
appears as `iz` in the DSL.

Following operators are supported at the moment:

| Operator            | JQL    | Kotlin DSL           | Example                             |
| --------------------|--------|----------------------|-------------------------------------|
| EQUALS              | =      | equalTo              | `Project equalTo "JQL"`             |
| NOT EQUALS          | !=     | notEqualTo           | `Component notEqualTo 239`          |
| GREATER THAN        | >      | greaterThan          | `TimeSpent greaterThan 3.days`      |
| GREATER THAN EQUALS | >=     | greaterThanOrEqualTo | `Priority greaterThanOrEqualTo 2`   |
| LESS THAN           | <      | lessThan             | `FixVersion lessThan "0.3"`         |
| LESS THAN EQUALS    | <=     | lessThanOrEqualTo    | `Votes lessThanOrEqualTo 100`       |
| IN                  | IN     | anyOf                | `Labels anyOf listOf("foo", "bar")` |
| NOT IN              | NOT IN | noneOf               | `Sprint noneOf ids(2, 3, 9)`        |
| CONTAINS            | ~      | contains             | `Text contains "jql"`               |
| DOES NOT CONTAIN    | !~     | doesNotContain       | `Summary doesNotContain "python"`   |
| IS                  | IS     | iz                   | `Resolution iz Empty`               |
| IS NOT              | IS NOT | izNot                | `Type izNot Null`                   |

### Functions

Some fields accept [functions](https://support.atlassian.com/jira-software-cloud/docs/advanced-search-reference-jql-functions/)
as arguments of the applicable operators. Such fields in the DSL provide type safe overloads which take functions
defined in `com.atlassian.jira.jql.function` package. A function call in the DSL looks exactly like in the real JQL:

```kotlin
Assignee equalTo currentUser()
```

If a function, in turn, takes some arguments, they appear as regular arguments in the DSL:

```kotlin
Approvals equalTo pendingBy("jdoe", "vpupkin")
```

### Order

To specify which fields to use for results sorting, use one of the `orderBy` function overloads on a JQL clause.
It takes fields with order direction as arguments. Unlike real JQL, order direction is required in the DSL.

```kotlin
Assignee equalTo currentUser() orderBy Created.desc  // assignee = currentUser() ORDER BY created DESC

Text contains "important" orderBy listOf(Project.asc, Created.desc)  // text ~ "important" ORDER BY project ASC, created DESC
```

Note that `orderBy` finalizes the query DSL, i.e. its return type is `String`. If you need to generate a JQL query
which does not have ordering, you'd need to call `toJql()` explicitly:

```kotlin
val dsl: Clause = Assignee equalTo "alice"
val jql: String = dsl.toJql()  // assignee = "alice"
```

To generate a JQL query which consists only of ORDER BY expression, use `orderBy()` notation:

```kotlin
val jql: String = orderBy(Updated.desc)  // ORDER BY updated DESC
```

### Duration and relative time

To express time interval for fields of type DURATION (e.g. `OriginalEstimate`, `TimeSpent`, etc.) use the shorthand
extension functions for `Int` type: `5.weeks`, `2.days`, `7.hours`, `15.minutes`.

These can be combined using plus operator:

```kotlin
3.weeks + 2.days  // "3w 2d" in JQL notation
```

Note that no actual mathematical operations are carried out because their outcome depends on Jira configuration
(e.g. a _day_ consists of only _working hours_, and a _week_ consists of _working days_).

To convert a duration into a relative timestamp us `ago` and `fromNow` notation:

```kotlin
5.days.ago  // "-5d"
(3.weeks + 2.days).fromNow  // "3w 2d"
```

Time interval DSL as well as fields of type DATE are intentionally more restrictive than real JQL
for the sake of type safety and readability. For instance, fields like `Created`, `Updated`, etc. don't allow
EQUALS, NOT EQUALS, IN and NOT IN operators because they require timestamps with minute precision equality.

### Value sanitization

All textual arguments in the DSL are sanitized when generating JQL query. Specifically, backslashes and double quotes
are escaped, and all whitespace characters are replaced with a space, and the result is put into double quotes:

```kotlin
Text contains "FOO\t\n\"BAR\"" orderBy Created.asc  // text ~ "FOO \"BAR\"" ORDER BY created ASC
```
