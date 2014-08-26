package com.jherenu.company;

public class Programmer extends Employee {
    private ProgrammerType programmerType;

    public Programmer(Long id, String name, String lastName, Integer age, ProgrammerType programmerType) {
        super(id, name, lastName, age);
        this.programmerType = programmerType;
    }

    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        if (!(other instanceof Programmer)) return false;
        if (!programmerType.equals(((Programmer) other).programmerType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 23;
        int result = 1;
        result = (result*PRIME) + super.hashCode();
        result = (result*PRIME) + this.programmerType.hashCode();
        return result;
    }
}
