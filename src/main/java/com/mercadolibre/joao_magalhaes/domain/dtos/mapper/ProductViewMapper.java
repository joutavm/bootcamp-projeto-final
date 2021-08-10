package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductViewMapper {

    public ProductView map(Product product){

        ProductView productView = new ProductView();
        productView.setName(product.getName());
        productView.setPrice(product.getPrice());
        productView.setCategory(product.getCategory().toString());
        return productView;
    }
}
