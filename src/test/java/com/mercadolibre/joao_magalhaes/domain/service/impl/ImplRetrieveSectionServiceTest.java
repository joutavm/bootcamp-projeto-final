package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.application.util.MockitoExtension;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.repository.SectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplRetrieveSectionServiceTest {

    @InjectMocks
    private ImplRetrieveSectionService implRetrieveSectionService;

    @Mock
    private SectionRepository sectionRepository;


    @BeforeEach
    void setUp(){
        implRetrieveSectionService = new ImplRetrieveSectionService(sectionRepository);
    }


    @Test
    void shouldFindSectionWhenSectionCodeAndWarehouseCodeExist() {
        // given
        Section expect = new Section();


        // when
        when(sectionRepository.findByCodeAndWarehouse_Code(any(), any())).thenReturn(Optional.of(expect));
        Section result = implRetrieveSectionService.findByNameAndWareHouse("1", "1");

        // Then
        assertEquals(expect, result);
    }

    @Test
    void shouldThorwExceptionWhenSectionCodeAndWarehouseCodeNotExist() {
        // given

        // when
        when(sectionRepository.findByCodeAndWarehouse_Code(any(), any())).thenReturn(Optional.empty());

        // Then
        assertThrows(ItemNotFoundException.class, () -> implRetrieveSectionService.findByNameAndWareHouse("1", "1"));
    }

















}