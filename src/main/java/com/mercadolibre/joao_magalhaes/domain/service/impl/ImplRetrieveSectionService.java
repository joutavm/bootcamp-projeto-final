package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.repository.SectionRepository;
import com.mercadolibre.joao_magalhaes.domain.service.RetrieveSectionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImplRetrieveSectionService implements RetrieveSectionService {

    private final SectionRepository sectionRepository;

    @Override
    public Section findByNameAndWareHouse(String sectionCode, String warehouseCode) throws ItemNotFoundException {
       return sectionRepository.findByCodeAndWarehouse_Code(sectionCode, warehouseCode)
               .orElseThrow( () -> new ItemNotFoundException("NOT FOUND", "Section does not exist", 404));

    }

}
