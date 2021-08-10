package com.mercadolibre.projeto_final.domain.repository;

import com.mercadolibre.projeto_final.domain.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<InboundOrder, Long> {


}
//select * from inbound_order_stock_list as i inner join inbound_order a on i.inbound_order_order_number = a.order_number inner join stock s on i.stock_list_number=s.number where s.product_id=2;
       //     "new com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductLocationSqlView(io.section, io.stockList)" +