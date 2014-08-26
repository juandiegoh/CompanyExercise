package com.jherenu.company;

public enum ProgrammerType {
    PHP("PHP"),
    NET(".NET"),
    PYTHON("Python");

    private final String description;

    ProgrammerType(String description) {
        this.description = description;
    }
}
