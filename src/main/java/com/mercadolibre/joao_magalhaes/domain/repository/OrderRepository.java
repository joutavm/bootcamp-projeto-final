package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<InboundOrder, Long> {


}
//select * from inbound_order_stock_list as i inner join inbound_order a on i.inbound_order_order_number = a.order_number inner join stock s on i.stock_list_number=s.number where s.product_id=2;
       //     "new com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView(io.section, io.stockList)" +