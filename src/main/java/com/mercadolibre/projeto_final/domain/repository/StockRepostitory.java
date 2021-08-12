package com.mercadolibre.projeto_final.domain.repository;

import com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductInWarehouseSqlView;
import com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.projeto_final.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepostitory extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT new com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductLocationSqlView(s.inboundOrder.section, s) FROM Stock s WHERE s.product.id = :id")
    List<ProductLocationSqlView> findByStockList(@Param("id") Long id);

    @Query(value = "SELECT s from Stock s where s.product.id = :prodId order by s.currentQuantity ASC ")
     List<Stock> findStocksWhereIdMatchesOrderAsc(@Param("prodId") Long prodId);

    @Query(value = "SELECT new com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductInWarehouseSqlView(s.inboundOrder.section.warehouse, SUM(s.currentQuantity)) FROM Stock s WHERE s.product.id=:id GROUP BY s.inboundOrder.section.warehouse")
    List<ProductInWarehouseSqlView> findByWarehouse(@Param("id") Long id);

    @Query(value = "SELECT new com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductInWarehouseSqlView(SUM(s.currentQuantity)) FROM Stock s WHERE s.product.id=:id GROUP BY s.inboundOrder.section.warehouse")
    ProductInWarehouseSqlView findByWarehouse2(@Param("id") Long id);

    List<Stock> findAllByDueDateLessThanEqual(LocalDate date);

    Long deleteAllByDueDateBefore(LocalDate date);

    List<Stock> findAllByInboundOrder_Section_Warehouse_Id(Long id);
}