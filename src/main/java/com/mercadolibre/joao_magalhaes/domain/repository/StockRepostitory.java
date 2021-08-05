package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepostitory extends JpaRepository<Stock, Long> {
}
