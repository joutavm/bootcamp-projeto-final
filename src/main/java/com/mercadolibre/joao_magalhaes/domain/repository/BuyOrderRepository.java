package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyOrderRepository  extends JpaRepository<BuyOrder, Long> {
}