package com.mercadolibre.projeto_final.domain.repository;

import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyOrderRepository  extends JpaRepository<BuyOrder, Long> {
}