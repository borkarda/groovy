package com.db.groovy

class Employee {

    String name;
    String age;
    String company

    public String getInfo() {
        return "Name: ${name}, Age: ${age}, Company: ${company}";
    }
}

c = new Employee(name:"Devendra", age:"36", company:"Siemens");
println(c.getInfo())
println('----------------')


