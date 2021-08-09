package com.mercadolibre.joao_magalhaes.domain.model;

public enum BuyOrderStatusEnum {

    CO("Completed"), PR("Proccessing"), CR("Created");

    private final String name;

    BuyOrderStatusEnum(String s) {
        this.name=s;
    }

    public String toString() {
        return this.name;
    }



}