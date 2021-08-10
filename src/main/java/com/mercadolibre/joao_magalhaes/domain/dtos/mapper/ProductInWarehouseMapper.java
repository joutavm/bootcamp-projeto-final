package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductInWarehouseSqlView;
import org.springframework.stereotype.Component;

@Component
public class ProductInWarehouseMapper {
    public ProductInWarehouseView map(ProductInWarehouseSqlView productInWarehouseSqlView){
        ProductInWarehouseView productInWarehouseView = new ProductInWarehouseView();
        productInWarehouseView.setWarehouseCode(productInWarehouseSqlView.getWarehouse().getCode());
        productInWarehouseView.setTotalQuantity(productInWarehouseSqlView.getTotalQuantity().intValue());
        return productInWarehouseView;
    }
}
