package com.jherenu.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Company {
    private Long id;
    private String name;
    private Map<Long, Employee> employees = new HashMap<Long, Employee>();

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        this.employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee getEmployeeById(Long employeeId) {
        return this.employees.get(employeeId);
    }


    public double getEmployeesAverageAge() {
        if(this.employees.isEmpty()) {
            return 0;
        }

        int ageSum = 0;
        int totalEmployeesCount = this.employees.size();
        for(Employee e : this.employees.values()) {
            ageSum += e.getAge();
        }

        return ageSum/totalEmployeesCount;
    }
}
