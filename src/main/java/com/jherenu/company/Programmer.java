package com.jherenu.company;

public class Programmer extends Employee {
    private ProgrammerType programmerType;

    public Programmer(Long id, String name, String lastName, Integer age, ProgrammerType programmerType) {
        super(id, name, lastName, age);
        this.programmerType = programmerType;
    }
}
