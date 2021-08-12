package com.mercadolibre.projeto_final.domain.service.impl;


import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.dtos.mapper.DueDateMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;
import com.mercadolibre.projeto_final.domain.exceptions.ApiException;
import com.mercadolibre.projeto_final.domain.model.CategoryProductEnum;
import com.mercadolibre.projeto_final.domain.model.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ImplDueDateServiceTest {

    @Mock
    private StockService stockService;
    @Mock
    private DueDateMapper dueDateMapper;

    ImplDueDate implDueDate;

    @BeforeEach
    void setUp() {
        implDueDate = new ImplDueDate(stockService, dueDateMapper);
    }


    @Test
    void shouldReturnDueDateViewList_whenPassingDays() {
        //given
        DueDateView dueDateView = new DueDateView();
        List<DueDateView> dueDateViewListExpected = new ArrayList<>();
        List<Stock> stockList = new ArrayList<>();
        Stock stock = new Stock();
        stockList.add(stock);

        //when
        when(stockService.findByDueDate(any())).thenReturn(stockList);
        when(dueDateMapper.map(any())).thenReturn(dueDateView);
        List<DueDateView> dueDateViewListResult = implDueDate.findByDueDate(1);

        //then
        assertEquals(dueDateView,dueDateViewListResult.get(0));

    }

    @Test
    void shouldReturnExcepction_WhenPassingInvalidDays() {
        //given
        DueDateView dueDateView = new DueDateView();
        List<DueDateView> dueDateViewListExpected = new ArrayList<>();
        List<Stock> stockList = new ArrayList<>();
        Stock stock = new Stock();
        stockList.add(stock);

        //when
        when(stockService.findByDueDate(any())).thenReturn(stockList);
        when(dueDateMapper.map(any())).thenReturn(dueDateView);
        //List<DueDateView> dueDateViewListResult = implDueDate.findByDueDate(-1);

        //then
        assertThrows(ApiException.class, () -> implDueDate.findByDueDate(-1));

    }

    @Test
    void shouldFindByDueDateSorted_WhenPassingValidDaysCategoryOrder(){
        //given
        ImplDueDate implDueDateSpy = Mockito.spy(implDueDate);

        DueDateView dueDateView = new DueDateView();
        dueDateView.setDueDate("05-05-2020");
        dueDateView.setCategory(CategoryProductEnum.RF.toString());

        DueDateView dueDateView2 = new DueDateView();
        dueDateView2.setDueDate("04-04-2020");
        dueDateView2.setCategory(CategoryProductEnum.RF.toString());

        DueDateView dueDateView3 = new DueDateView();
        dueDateView3.setDueDate("04-04-2020");
        dueDateView3.setCategory(CategoryProductEnum.FF.toString());

        DueDateView dueDateView4 = new DueDateView();
        dueDateView4.setDueDate("03-03-2020");
        dueDateView4.setCategory(CategoryProductEnum.FF.toString());

        DueDateView dueDateView5 = new DueDateView();
        dueDateView5.setDueDate("03-03-2020");
        dueDateView5.setCategory(CategoryProductEnum.FS.toString());

        DueDateView dueDateView6 = new DueDateView();
        dueDateView6.setDueDate("02-02-2020");
        dueDateView6.setCategory(CategoryProductEnum.FS.toString());

        List<DueDateView> dueDateViewList = new ArrayList<>();
        dueDateViewList.add(dueDateView);
        dueDateViewList.add(dueDateView2);
        dueDateViewList.add(dueDateView3);
        dueDateViewList.add(dueDateView4);
        dueDateViewList.add(dueDateView5);
        dueDateViewList.add(dueDateView6);

        //when
        doReturn(dueDateViewList).when(implDueDateSpy).findByDueDate(1);
        List<DueDateView> result = implDueDateSpy.findByDueDateSorted(1, "RF", "ASC");
        List<DueDateView> result1 = implDueDateSpy.findByDueDateSorted(1, "FF", "ASC");
        List<DueDateView> result2 = implDueDateSpy.findByDueDateSorted(1, "FS", "ASC");

        //then
        assertEquals(2,result.size());
        assertEquals(dueDateView2,result.get(0));
        assertEquals(dueDateView4,result1.get(0));
        assertEquals(dueDateView6,result2.get(0));
    }

}
