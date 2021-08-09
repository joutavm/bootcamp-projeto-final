package com.mercadolibre.joao_magalhaes.domain.exceptions;

public class OrderNotUpdatedException extends ApiException{

    public OrderNotUpdatedException(String code, String description, Integer statusCode) {
        super(code, description, statusCode);
    }

    public OrderNotUpdatedException(String code, String description, Integer statusCode, Throwable cause) {
        super(code, description, statusCode, cause);
    }
}