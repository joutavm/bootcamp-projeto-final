package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductInWarehouseSqlView;
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
