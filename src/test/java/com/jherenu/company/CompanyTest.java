package com.jherenu.company;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;

public class CompanyTest {

    private static final String NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final int AGE = 20;

    private static final String ANOTHER_NAME = "N";
    private static final String ANOTHER_LAST_NAME = "N";
    private static final int ANOTHER_AGE = 30;

    private Company company;
    private static final String COMPANY_NAME = "Company";

    @Before
    public void setup() {
        this.company = new Company(0L, COMPANY_NAME);
    }

    @Test
    public void testAddEmployeeAndCheckIsPresent() {
        // given
        Employee newEmployee = new Employee(1L, NAME, LAST_NAME, AGE);

        // when
        this.company.addEmployee(newEmployee);

        // then
        Employee foundEmployee = this.company.getEmployeeById(1L);
        assertEquals(foundEmployee, newEmployee);
    }

    @Test
    public void testAddEmployeesAndCheckIfTheyAreAllPresent() {
        // given
        Employee newEmployee = new Employee(1L, NAME, LAST_NAME, AGE);
        Employee anotherNewEmployee = new Programmer(2L, ANOTHER_NAME, ANOTHER_LAST_NAME, ANOTHER_AGE, ProgrammerType.PYTHON);
        this.company.addEmployee(newEmployee);
        this.company.addEmployee(anotherNewEmployee);

        // when
        Collection<Employee> allEmployees = this.company.getAllEmployees();

        // then
        assertTrue(allEmployees.contains(newEmployee));
        assertTrue(allEmployees.contains(anotherNewEmployee));
    }

    @Test
    public void testEmployeesAgeAverageIsCalculated() {
        // given
        Employee newEmployee = new Employee(1L, NAME, LAST_NAME, AGE);
        Employee anotherNewEmployee = new Designer(2L, ANOTHER_NAME, ANOTHER_LAST_NAME, ANOTHER_AGE, DesignerType.GRAPHIC);
        this.company.addEmployee(newEmployee);
        this.company.addEmployee(anotherNewEmployee);

        // when
        double average = this.company.getEmployeesAverageAge();

        // then
        assertEquals(25, average, 0.001);
    }

    @Test
    public void testNoEmployeesAgeAverageIsZero() {
        // when
        double average = this.company.getEmployeesAverageAge();

        // then
        assertEquals(0, average, 0.001);
    }
}
