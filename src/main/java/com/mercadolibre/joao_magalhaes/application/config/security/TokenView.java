package com.mercadolibre.joao_magalhaes.application.config.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokenView {

    private final String token;
    private final String type;

}
