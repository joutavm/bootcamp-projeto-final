package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductWithIdWarehouseView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StocksByProductInWarehousesMapper {
    public ProductWithIdWarehouseView map(List<ProductInWarehouseView> productInWarehouseViewList, Long productId){
        ProductWithIdWarehouseView productList = new ProductWithIdWarehouseView();
        productList.setProductId(productId);
        productList.setProductInWarehouseViewList(productInWarehouseViewList);

        return productList;
    }
}
