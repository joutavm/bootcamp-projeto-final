package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Section;

public interface RetrieveSectionService {

    Section findByNameAndWareHouse(String sectionCode, String WarehouseCode) throws ItemNotFoundException;
}
