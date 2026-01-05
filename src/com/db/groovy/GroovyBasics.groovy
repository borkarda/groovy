package com.db.groovy

println('Hello, Groovy!')

def a = 55 // generic type, based on the value , type is decided at runtime
println('Value: '+a)
println("Type: "+a.getClass().getName())
float b= 45.67
println('Value: '+b)
println("Type: "+b.getClass().getName())
println('----------------')

s ='Devendra'
println(s)
name = "Hello, ${s}!"
println(name)
println('----------------')

multiLineString = '''This is a multi-line string.
It can span multiple lines.
Groovy makes it easy!'''
println(multiLineString)
println('----------------')

emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
isValid = "test@gmail.com"==~emailPattern
println("Is valid email: "+isValid)
println('----------------')

def add = { int x, int y -> return x + y }
result = add(10, 20)
println("Addition Result: "+result)
println('----------------')

def greet = { name -> println("Hello, ${name}!") }
greet("Devendra")
println('----------------')

def numbers = [1, 2, 3, 4, 5]
squaredNumbers = numbers.collect { it * it }
println("Squared Numbers: "+squaredNumbers)
println('----------------')

def evenNumbers = numbers.findAll { it % 2 == 0 }
println("Even Numbers: "+evenNumbers)
println('----------------')

def factorial
factorial = { int n ->
    if (n <= 1) {
        return 1
    } else {
        return n * factorial(n - 1)
    }
}
factResult = factorial(5)
println("Factorial Result: "+factResult)
println('----------------')

class Person {
    String name
    int age

    void introduce() {
        println("Hello, my name is ${name} and I am ${age} years old.")
    }
}
def person = new Person(name: 'Devendra', age: 36)
person.introduce()
println('----------------')

def map = [name: 'Devendra', age: 36, city: 'New York']
map.each { key, value ->
    println("${key}: ${value}")
}
println('----------------')

try {
    int division = 10 / 0
} catch (ArithmeticException e) {
    println("Caught an exception: " + e.getMessage())
} finally {
    println("Execution completed.")
}
println('----------------')

for (i in 1..5) {
    println("Iteration: "+i)
}
println('----------------')

int count = 1
while (count <= 5) {
    println("Count: "+count)
    count++
}

println('----------------')

5.times {println(it)}

println('GROOVY BASICS completed')
