package com.mercadolibre.projeto_final.domain.model;

public enum CategoryProductEnum {
    FS("Fresh"), RF("Refrigerado"), FF("Congelado");

    private final String name;

    CategoryProductEnum(String s) {
        this.name=s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
