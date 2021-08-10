package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import com.mercadolibre.joao_magalhaes.domain.service.RetrieveProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ImplRetrieveProductService implements RetrieveProductService {

    private final ProductViewMapper productViewMapper;
    private final FindProductService findProductService;

    @Override
    public List<ProductView> retrieveProductViewList(){
        List<Product> productList = findProductService.findAll();
        return productList.stream().map(e -> productViewMapper.map(e)).collect(Collectors.toList());
    }
}
