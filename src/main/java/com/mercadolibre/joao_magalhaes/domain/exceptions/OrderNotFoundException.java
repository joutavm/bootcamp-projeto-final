package com.mercadolibre.joao_magalhaes.domain.exceptions;

public class OrderNotFoundException extends ApiException {

    public OrderNotFoundException(String code, String description, Integer statusCode) {
        super(code, description, statusCode);
    }

}
