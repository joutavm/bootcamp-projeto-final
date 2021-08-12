package com.mercadolibre.projeto_final.domain.repository;

import com.mercadolibre.projeto_final.domain.model.CategoryProductEnum;
import com.mercadolibre.projeto_final.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findByCategory(CategoryProductEnum category);

    @Query("SELECT p from Product p WHERE UPPER(p.name)=UPPER(:name)")
    Optional<Product> findByName(String name);
}
