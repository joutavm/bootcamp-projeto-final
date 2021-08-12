package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Product;
import com.mercadolibre.projeto_final.domain.repository.ProductRepository;
import com.mercadolibre.projeto_final.domain.service.FindProductByNameService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ImplFindProductByName implements FindProductByNameService {

    private final ProductRepository productRepository;
    private final ProductViewMapper productViewMapper;


    @Override
    public ProductView findProductByName(String name) {
        Optional<Product> product = productRepository.findByName(name);

        if(product.isEmpty()){
            throw new ItemNotFoundException("Not Found", "Product Not Found!", 404);
        }

        return productViewMapper.map(product.get());
    }
}
