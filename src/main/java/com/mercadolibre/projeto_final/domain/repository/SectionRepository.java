package com.mercadolibre.projeto_final.domain.repository;

import com.mercadolibre.projeto_final.domain.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {

    Optional<Section> findByCodeAndWarehouse_Code(String sectionCode, String warehouseCode);
}
