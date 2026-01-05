package com.db.groovy
println('Collection Demo in Groovy!')

def fruits = ['Apple', 'Banana', 'Cherry', 'Date', 'Elderberry']
println("Fruits List: "+fruits)
println('----------------')

def upperFruits = fruits.collect { it.toUpperCase() }
println("Uppercase Fruits: "+upperFruits)
println('----------------')

def longFruits = fruits.findAll { it.length() > 5 }
println("Fruits with more than 5 letters: "+longFruits)
println('----------------')

def fruitMap = fruits.collectEntries { [(it): it.length()] }
println("Fruit Length Map: "+fruitMap)
println('----------------')

def sortedFruits = fruits.sort { it.length() }
println("Fruits sorted by length: "+sortedFruits)
println('----------------')

def concatenatedFruits = fruits.inject('Fruits: ') { acc, fruit -> acc + fruit + ' ' }
println("Concatenated Fruits: "+concatenatedFruits)
println('----------------')

def lst = [5, 3, 8, 1, 2]
println(lst)
println(lst.sort())
println(lst.class)
lst << 4 // adding element
println(lst-[5]) // removing element
println(lst)

println('----------------')
// Set demo
s = [1,2,3,4,5,5,4,3] as Set // duplicate elements will be removed
println(s.class)
println(s)

// map demo
m = [name:'Devendra', age:36, city:'New York']
println(m.class)
m.each { k,v -> println("$k : $v") }
println(m.name)
m.company='Siemens' // adding new key-value pair
println(m)

println('End of Collection Demo!')