package com.db.groovy

println('Closure Demo in Groovy!')

isEvenOdd =
        {
            int num -> return num % 2 == 0 ? "even":"odd"
        }
println("10 is "+isEvenOdd(10)) // isEvenOdd.call(10) also works
println("7 is "+isEvenOdd(7))
println(isEvenOdd.call()) // will throw : MissingMethodException
println('----------------')