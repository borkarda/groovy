# Groovy Project

This repository contains simple Groovy scripts demonstrating core language features. If you’re new to Groovy, this README explains what it is, why you might use it, how it differs from Java, and showcases important features with examples.

## What is Groovy?

Groovy is a powerful, optionally-typed, and dynamic language for the JVM (Java Virtual Machine). It integrates seamlessly with Java, offering a concise syntax, modern features (closures, builders, metaprogramming), and productivity-focused utilities for everyday scripting and application development.

- Runs on the JVM and compiles to bytecode
- Uses the Java class library and interops with existing Java code
- Can be used as a scripting language or for building full applications

Official site: https://groovy-lang.org/

## Why use Groovy?

- Developer productivity: Less boilerplate than Java, faster to write and read
- Scripting + Applications: Versatile for automation scripts, CLIs, microservices, and web apps
- Interoperability: Call Java code directly; mix and match Groovy and Java classes
- Modern language features: Closures, dynamic typing, builders, string interpolation, powerful collections
- Great tooling: Works with Gradle, Spock testing, and popular JVM frameworks

## How Groovy differs from Java

Groovy aims to be compatible with Java but adds dynamic features and syntactic sugar:

- Optional typing: You can omit types; Groovy determines them at runtime (or you can annotate types when desired)
- Concise syntax: Semicolons optional, getters/setters often unnecessary, parentheses often optional
- Closures (lambdas): First-class function objects with convenient syntax
- Truthiness: Many objects have boolean truth semantics (`[]` and `''` are falsey)
- GStrings: String interpolation with `${}`
- Collection literals and helpers: Lists `[1,2,3]`, maps `[key: 'value']`, and rich methods like `collect`, `findAll`
- Operators and ranges: `1..5` creates a range; `==~` for regex match, `*.` spread operator, safe navigation `?.`

Despite differences, Groovy compiles to JVM bytecode and can call Java libraries directly.

## Usage

This project is a simple, library-free Groovy setup using local Groovy JARs under `lib/`. You can run the scripts directly.

Quick try (Windows cmd.exe):

```
set CLASSPATH=lib\groovy-5.0.0.jar;lib\groovy-json-5.0.0.jar;lib\groovy-xml-5.0.0.jar;lib\groovy-cli-commons-5.0.0.jar;lib\groovy-cli-picocli-5.0.0.jar;lib\groovy-ant-5.0.0.jar;lib\groovy-dateutil-5.0.0.jar;lib\groovy-sql-5.0.0.jar;lib\groovy-toml-5.0.0.jar;lib\groovy-nio-5.0.0.jar;.
java org.codehaus.groovy.tools.GroovyStarter --main groovy.ui.GroovyMain src\com\db\groovy\GroovyBasics.groovy
```

Alternatively, if you have a system Groovy installation:

```
groovy src\com\db\groovy\GroovyBasics.groovy
```

Note: Adjust the `CLASSPATH` if needed based on your environment; IntelliJ IDEA can also run Groovy scripts directly if configured with the Groovy SDK.

## Important Groovy features with examples

Below are small, focused examples (kept simple for clarity). They align with what you’ll find in `src/com/db/groovy/GroovyBasics.groovy`.

1) Dynamic typing and type inference

```
def a = 55          // type inferred at runtime
println a.getClass().name  // java.lang.Integer
```

Benefit: Less ceremony; types where helpful, omit where not.

2) String interpolation (GStrings)

```
def name = 'Devendra'
println "Hello, ${name}!"   // inserts variable into string
```

Benefit: Readable string composition without `+` concatenation.

3) Multi-line strings

```
def multi = '''This is a multi-line string.
It can span multiple lines.
Groovy makes it easy!'''
println multi
```

Benefit: Easy to embed blocks of text.

4) Regular expressions and matching

```
def emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
println "Is valid: " + ("test@gmail.com" ==~ emailPattern)
```

Benefit: Simple regex syntax with match operators.

5) Closures (anonymous functions)

```
def add = { int x, int y -> x + y }
println add(10, 20)   // 30
```

Benefit: Functional style programming and callbacks.

6) Collection literals and higher-order methods

```
def numbers = [1, 2, 3, 4, 5]
def squares = numbers.collect { it * it }
println squares    // [1, 4, 9, 16, 25]

def evens = numbers.findAll { it % 2 == 0 }
println evens      // [2, 4]
```

Benefit: Expressive transformations and filtering.

7) Recursion with closures

```
def factorial
factorial = { int n -> n <= 1 ? 1 : n * factorial(n - 1) }
println factorial(5)  // 120
```

Benefit: Demonstrates closures referencing themselves; expressive algorithms.

8) Simple classes and properties

```
class Person {
  String name
  int age
  void introduce() { println "Hello, my name is ${name} and I am ${age} years old." }
}
new Person(name: 'Devendra', age: 36).introduce()
```

Benefit: Concise POJOs; properties auto-generate getters/setters; named-arg constructor syntax.

9) Maps and iteration

```
def map = [name: 'Devendra', age: 36, city: 'New York']
map.each { k, v -> println "$k: $v" }
```

Benefit: Built-in map literal and convenient traversal.

10) Exceptions

```
try {
  def division = 10 / 0
} catch (ArithmeticException e) {
  println "Caught: ${e.message}"
} finally {
  println "Cleanup"
}
```

Benefit: Same try/catch/finally model as Java but with cleaner syntax.

11) Ranges and loops

```
for (i in 1..5) { println "Iteration: $i" }

int count = 1
while (count <= 5) { println "Count: $count"; count++ }

5.times { println it }   // 0 to 4
```

Benefit: Expressive iteration constructs and helpers like `times`.

12) Safe navigation and null handling (extra)

```
// Safe navigation avoids NullPointerException
println someObj?.child?.name  // prints null if any segment is null

// Elvis operator for defaulting
def username = provided ?: 'guest'
```

Benefit: Fewer NPEs and cleaner defaulting.

## Interoperability with Java

Because Groovy runs on the JVM, you can:

- Instantiate and use Java classes directly
- Call Groovy from Java and vice versa
- Reuse Java libraries without wrappers

Example:

```
import java.time.LocalDate
println LocalDate.now()
```

## Project structure

- `src/com/db/groovy/GroovyBasics.groovy`: A single script demonstrating core features.
- `src/com/db/groovy/ClassDemo.groovy`: Contains `Employee` class and a small demo.
- `test/com/db/groovy/GroovyBasicsTest.groovy`: Test runner validating `GroovyBasics` output.
- `test/com/db/groovy/EmployeeTest.groovy`: Tests `Employee` scenarios (construction, mutation, nulls).
- `lib/`: Groovy JARs used to run the script without a separate installation.

## Running tests

You can run the test scripts using either the local JARs (via `GroovyStarter`) or a system Groovy installation.

Windows (cmd.exe) using local JARs:

```
set CLASSPATH=lib\groovy-5.0.0.jar;lib\groovy-json-5.0.0.jar;lib\groovy-xml-5.0.0.jar;lib\groovy-cli-commons-5.0.0.jar;lib\groovy-cli-picocli-5.0.0.jar;lib\groovy-ant-5.0.0.jar;lib\groovy-dateutil-5.0.0.jar;lib\groovy-sql-5.0.0.jar;lib\groovy-toml-5.0.0.jar;lib\groovy-nio-5.0.0.jar;.
java org.codehaus.groovy.tools.GroovyStarter --main groovy.ui.GroovyMain test\com\db\groovy\GroovyBasicsTest.groovy
java org.codehaus.groovy.tools.GroovyStarter --main groovy.ui.GroovyMain test\com\db\groovy\EmployeeTest.groovy
```

If you have Groovy installed:

```
groovy test\com\db\groovy\GroovyBasicsTest.groovy
groovy test\com\db\groovy\EmployeeTest.groovy
```

Each test will print `ALL TESTS PASSED` upon success.

## Next steps

- Add unit tests using Spock (`groovy-test`, `spock-core`) for behavior-driven specs
- Explore builders (XML/JSON) and `@Immutable`, `@Canonical` AST transforms
- Try the Groovy shell (`groovysh`) for interactive experimentation
- Use Gradle for builds and dependency management

## Troubleshooting

- Classpath errors: Ensure all required Groovy JARs are on the `CLASSPATH`. IntelliJ run configuration may manage this automatically.
- Windows quoting: Use double quotes carefully in `cmd.exe` when passing parameters. The examples above avoid special quoting.

Happy Grooving!
