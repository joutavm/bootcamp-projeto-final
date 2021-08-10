package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductLocationView;
import com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductLocationSqlView;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ProductLocationMapper {
    public ProductLocationView map(ProductLocationSqlView productLocationSqlView){

        ProductLocationView productLocationView = new ProductLocationView();
        productLocationView.setProductId(productLocationSqlView.getStock().getProduct().getId());
        productLocationView.setSectionCode(productLocationSqlView.getSection().getCode());
        productLocationView.setWarehouseCode(productLocationSqlView.getSection().getWarehouse().getCode());
        productLocationView.setBatchNumber(productLocationSqlView.getStock().getNumber());
        productLocationView.setCurrentQuantity(productLocationSqlView.getStock().getCurrentQuantity());
        productLocationView.setDueDate(productLocationSqlView.getStock().getDueDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        return productLocationView;
    }
}
