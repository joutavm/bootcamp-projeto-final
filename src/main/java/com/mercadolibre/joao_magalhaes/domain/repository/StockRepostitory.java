package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepostitory extends JpaRepository<Stock, Long> {
    //Find que devolve todos os estoques que tem aquele produto, e ordernar ascendente
}