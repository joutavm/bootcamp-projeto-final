package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.model.Product;
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
