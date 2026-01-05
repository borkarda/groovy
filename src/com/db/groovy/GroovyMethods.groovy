package com.db.groovy

println('Groovy Methods Demo!')

def sayHello() {
    return 'Hello from Groovy Method!'
}
println(sayHello())
println('----------------')

def addNumbers(int x, int y) {
    return x + y
}
sum = addNumbers(15, 25)
println("Sum: "+sum)
println('----------------')

def greetPerson(String name='Guest') { // default parameter, if no argument passed, 'Guest' will be used
    return "Hello, ${name}!"
}
println(greetPerson('Devendra'))