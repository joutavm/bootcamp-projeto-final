package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductWithIdWarehouseView;
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
