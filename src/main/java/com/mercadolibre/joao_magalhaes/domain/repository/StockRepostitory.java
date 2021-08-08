package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepostitory extends JpaRepository<Stock, Long> {
    //Find que devolve todos os estoques que tem aquele produto, e ordernar ascendente
    @Query(value = "SELECT s from Stock s where s.product.id = :prodId order by s.currentQuantity ASC ")
     List<Stock> findStocksWhereIdMatchesOrderAsc(@Param("prodId") Long prodId);
}