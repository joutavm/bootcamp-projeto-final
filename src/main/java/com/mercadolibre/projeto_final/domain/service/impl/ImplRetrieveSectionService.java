package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.repository.SectionRepository;
import com.mercadolibre.projeto_final.domain.service.RetrieveSectionService;
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
