package com.jherenu.company;

public enum DesignerType {
    GRAPHIC("Graphic"),
    WEB("WEB");

    private final String description;

    DesignerType(String description) {
        this.description = description;
    }
}
