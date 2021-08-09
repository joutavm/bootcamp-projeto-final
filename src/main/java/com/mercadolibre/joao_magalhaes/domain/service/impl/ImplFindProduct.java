package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.CategoryProductEnum;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.repository.ProductRepository;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ImplFindProduct implements FindProductService {

    private final ProductRepository productRepository;
    private final ProductViewMapper productViewMapper;

    @Override
    public Product findById(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Not Found", "Product not found.", 404));
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()){
            throw new ItemNotFoundException("Not Found", "List of Products is empty!", 404);
        }

        return productList;
    }

    @Override
    public List<ProductView> findAllProductsByCategory(String category) {
        List<Product> products;

        try {
           CategoryProductEnum categoryEnum = CategoryProductEnum.valueOf(category);

           products = productRepository
                    .findByCategory(categoryEnum)
                    .orElseThrow(() -> new ItemNotFoundException("Not Found", "List of Products is empty!", 404));

        } catch (Exception e) {
            throw new ItemNotFoundException("Not Found", "Category not found!", 404);
        }

        return products.stream().map(productViewMapper::map).collect(Collectors.toList());
    }
}