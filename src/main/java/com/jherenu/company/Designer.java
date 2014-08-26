package com.jherenu.company;

public class Designer extends Employee {

    private DesignerType designerType;

    public Designer(Long id, String name, String lastName, Integer age, DesignerType designerType) {
        super(id, name, lastName, age);
        this.designerType = designerType;
    }
}
