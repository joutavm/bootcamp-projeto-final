package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.model.CategoryProductEnum;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findByCategory(CategoryProductEnum category);
}
