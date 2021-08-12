package com.mercadolibre.projeto_final.domain.model;

public enum BuyOrderStatusEnum {

    CO("Completed"), PR("Proccessing"), CR("Created"), FL("Failed");

    private final String name;

    BuyOrderStatusEnum(String s) {
        this.name=s;
    }

    public String toString() {
        return this.name;
    }



}