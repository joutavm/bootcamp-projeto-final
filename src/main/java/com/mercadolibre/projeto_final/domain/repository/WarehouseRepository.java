package com.mercadolibre.projeto_final.domain.repository;

import com.mercadolibre.projeto_final.domain.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
