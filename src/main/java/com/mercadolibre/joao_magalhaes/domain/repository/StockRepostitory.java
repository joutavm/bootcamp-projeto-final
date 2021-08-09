package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepostitory extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT new com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView(s.inboundOrder.section, s) FROM Stock s WHERE s.product.id = :id")
    List<ProductLocationSqlView> findByStockList(@Param("id") Long id);

    @Query(value = "SELECT s from Stock s where s.product.id = :prodId order by s.currentQuantity ASC ")
     List<Stock> findStocksWhereIdMatchesOrderAsc(@Param("prodId") Long prodId);
}