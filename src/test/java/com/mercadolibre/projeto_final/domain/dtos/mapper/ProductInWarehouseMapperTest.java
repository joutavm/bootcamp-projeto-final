package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductInWarehouseSqlView;
import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.model.Warehouse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductInWarehouseMapperTest {

    private final ProductInWarehouseMapper productInWarehouseMapper = new ProductInWarehouseMapper();

    @Test
    public void shouldReturnProductInWarehouseView_GivenValidProductInWarehouseSqlView(){
        //Given
        ProductInWarehouseView expected = new ProductInWarehouseView("10", 10);
        Section section1 = new Section("12", 200.2,
                new Warehouse("10", List.of(new Section(), new Section())));
        Section section2 = new Section("12", 200.2,
                new Warehouse("10", List.of(new Section(), new Section())));
        List<Section> sectionList = new ArrayList<>();
        sectionList.add(section1);
        sectionList.add(section2);
        Warehouse warehouse = new Warehouse("10",sectionList);
        ProductInWarehouseSqlView given = new ProductInWarehouseSqlView(warehouse,10L);


        //When
        ProductInWarehouseView map = productInWarehouseMapper.map(given);


        //Then
        assertEquals(map.getTotalQuantity(),expected.getTotalQuantity());
        assertEquals(map.getWarehouseCode(),expected.getWarehouseCode());
    }
}
