package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductLocationView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
