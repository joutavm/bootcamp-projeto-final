package com.mercadolibre.joao_magalhaes.domain.exceptions;

public class ItemNotFoundException extends ApiException {

    public ItemNotFoundException(String code, String description, Integer statusCode) {
        super(code, description, statusCode);
    }

    public ItemNotFoundException(String code, String description, Integer statusCode, Throwable cause) {
        super(code, description, statusCode, cause);
    }
}
