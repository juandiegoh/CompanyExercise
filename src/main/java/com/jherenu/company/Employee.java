package com.jherenu.company;

public class Employee {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;

    public Employee(Long id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof Employee)) return false;
        if (id != ((Employee) other).getId()) return false;
        if (name != ((Employee) other).name) return false;
        if (lastName != ((Employee) other).lastName) return false;
        if (age != ((Employee) other).age) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 23;
        int result = 1;
        result = (result*PRIME) + super.hashCode();
        result = (result*PRIME) + this.id.hashCode();
        result = (result*PRIME) + this.name.hashCode();
        result = (result*PRIME) + this.lastName.hashCode();
        result = (result*PRIME) + this.age;
        return result;
    }

    public Integer getAge() {
        return age;
    }
}
