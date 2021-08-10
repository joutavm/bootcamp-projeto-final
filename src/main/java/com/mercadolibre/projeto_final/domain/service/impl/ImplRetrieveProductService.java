package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.model.Product;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import com.mercadolibre.projeto_final.domain.service.RetrieveProductService;
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
