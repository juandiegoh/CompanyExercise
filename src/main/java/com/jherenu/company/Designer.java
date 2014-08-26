package com.jherenu.company;

public class Designer extends Employee {

    private DesignerType designerType;

    public Designer(Long id, String name, String lastName, Integer age, DesignerType designerType) {
        super(id, name, lastName, age);
        this.designerType = designerType;
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        if (!(other instanceof Designer)) return false;
        if (!designerType.equals(((Designer) other).designerType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 23;
        int result = 1;
        result = (result*PRIME) + super.hashCode();
        result = (result*PRIME) + this.designerType.hashCode();
        return result;
    }
}
