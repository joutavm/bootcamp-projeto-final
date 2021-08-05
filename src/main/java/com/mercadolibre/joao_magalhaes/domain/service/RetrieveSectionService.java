package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.Section;

public interface RetrieveSectionService {

    Section findByNameAndWareHouse(String sectionCode, String WarehouseCode) throws ItemNotFoundException;
}
