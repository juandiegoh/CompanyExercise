package com.jherenu.company;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;

public class CompanyTest {

    private static final String PROGRAMMER_NAME = "N";
    private static final String PROGRAMMER_LAST_NAME = "N";
    private static final int PROGRAMMER_AGE = 30;

    private static final String DESIGNER_NAME = "Fulana";
    private static final String DESIGNER_LAST_NAME = "Mengana";
    private static final int DESIGNER_AGE = 40;

    private Company company;
    private static final String COMPANY_NAME = "Company";

    @Before
    public void setup() {
        this.company = new Company(0L, COMPANY_NAME);
    }

    @Test
    public void testAddEmployeeAndCheckIsPresent() {
        // given
        Employee newEmployee = new Programmer(1L, PROGRAMMER_NAME, PROGRAMMER_LAST_NAME, PROGRAMMER_AGE, ProgrammerType.PYTHON);

        // when
        this.company.addEmployee(newEmployee);

        // then
        Employee foundEmployee = this.company.getEmployeeById(1L);
        assertEquals(foundEmployee, newEmployee);
    }

    @Test
    public void testAddEmployeesAndCheckIfTheyAreAllPresent() {
        // given
        Employee programmerNewEmployee = new Programmer(2L, PROGRAMMER_NAME, PROGRAMMER_LAST_NAME, PROGRAMMER_AGE, ProgrammerType.PYTHON);
        Employee designerNewEmployee = new Designer(3L, DESIGNER_NAME, DESIGNER_LAST_NAME, DESIGNER_AGE, DesignerType.GRAPHIC);
        this.company.addEmployee(programmerNewEmployee);
        this.company.addEmployee(designerNewEmployee);

        // when
        Collection<Employee> allEmployees = this.company.getAllEmployees();

        // then
        assertTrue(allEmployees.contains(programmerNewEmployee));
        assertTrue(allEmployees.contains(designerNewEmployee));
    }

    @Test
    public void testEmployeesAgeAverageIsCalculated() {
        // given
        Employee anotherNewEmployee = new Designer(2L, PROGRAMMER_NAME, PROGRAMMER_LAST_NAME, PROGRAMMER_AGE, DesignerType.GRAPHIC);
        Employee designerNewEmployee = new Designer(3L, DESIGNER_NAME, DESIGNER_LAST_NAME, DESIGNER_AGE, DesignerType.GRAPHIC);
        this.company.addEmployee(anotherNewEmployee);
        this.company.addEmployee(designerNewEmployee);

        // when
        double average = this.company.getEmployeesAverageAge();

        // then
        assertEquals(35, average, 0.001);
    }

    @Test
    public void testNoEmployeesAgeAverageIsZero() {
        // when
        double average = this.company.getEmployeesAverageAge();

        // then
        assertEquals(0, average, 0.001);
    }
}
