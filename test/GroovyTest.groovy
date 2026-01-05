package com.db.groovy

import groovy.lang.GroovyShell

/**
 * Tests for Employee class defined in ClassDemo.groovy.
 * Scenarios covered:
 * - Named-argument construction sets properties
 * - getInfo formats string correctly
 * - Properties are mutable after construction
 * - Missing properties remain null and are reflected in getInfo
 */
class EmployeeTest {
    static void main(String[] args) {
        // Ensure the Employee class from ClassDemo.groovy is compiled/loaded
        def shell = new GroovyShell()
        shell.parse(new File('src/com/db/groovy/ClassDemo.groovy'))

        // 1) Named-argument construction
        def e1 = new Employee(name: 'Devendra', age: '36', company: 'Siemens')
        assert e1.name == 'Devendra'
        assert e1.age == '36'
        assert e1.company == 'Siemens'
        assert e1.getInfo() == 'Name: Devendra, Age: 36, Company: Siemens'

        // 2) Mutate properties and verify
        e1.age = '37'
        e1.company = 'Siemens Healthineers'
        assert e1.getInfo() == 'Name: Devendra, Age: 37, Company: Siemens Healthineers'

        // 3) Partially initialized employee
        def e2 = new Employee(name: 'Alex')
        assert e2.name == 'Alex'
        assert e2.age == null
        assert e2.company == null
        assert e2.getInfo() == 'Name: Alex, Age: null, Company: null'

        // 4) Empty employee and property assignment later
        def e3 = new Employee()
        assert e3.name == null && e3.age == null && e3.company == null
        e3.name = 'Priya'
        e3.age = '28'
        e3.company = 'Acme Corp'
        assert e3.getInfo() == 'Name: Priya, Age: 28, Company: Acme Corp'

        println 'EmployeeTest: ALL TESTS PASSED'
    }
}
