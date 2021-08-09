package com.mercadolibre.joao_magalhaes.application.config;

import com.mercadolibre.joao_magalhaes.application.controller.ProductLocationController;
import com.mercadolibre.joao_magalhaes.application.controller.PurchaseController;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.*;
import com.mercadolibre.joao_magalhaes.domain.repository.OrderRepository;
import com.mercadolibre.joao_magalhaes.domain.repository.ProductRepository;
import com.mercadolibre.joao_magalhaes.domain.repository.SectionRepository;
import com.mercadolibre.joao_magalhaes.domain.repository.StockRepostitory;
import com.mercadolibre.joao_magalhaes.domain.service.CreateOrderService;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import com.mercadolibre.joao_magalhaes.domain.service.ProductLocationService;
import com.mercadolibre.joao_magalhaes.domain.service.RetrieveSectionService;
import com.mercadolibre.joao_magalhaes.domain.service.impl.ImplCreateOrder;
import com.mercadolibre.joao_magalhaes.domain.service.impl.ImplFindProduct;
import com.mercadolibre.joao_magalhaes.domain.service.impl.ImplProductLocation;
import com.mercadolibre.joao_magalhaes.domain.service.impl.ImplRetrieveSectionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CreateOrderService createOrderService(
            OrderRepository orderRepository,
            StockViewMapper stockViewMapper,
            OrderFormMapper orderFormMapper,
            RetrieveSectionService retrieveSectionService,
            StockFormMapper stockFormMapper,
            FindProductService findProductService){
        return new ImplCreateOrder(orderRepository, stockViewMapper, orderFormMapper, retrieveSectionService, stockFormMapper, findProductService);
    }

    @Bean
    public RetrieveSectionService retrieveSectionService(SectionRepository sectionRepository){
        return new ImplRetrieveSectionService(sectionRepository);
    }

    @Bean
    public FindProductService findProductService(ProductRepository productRepository, ProductViewMapper productViewMapper){
        return new ImplFindProduct(productRepository, productViewMapper);
    }

    @Bean
    public ProductLocationService productLocationService(StockRepostitory stockRepostitory, ProductLocationMapper productLocationMapper){
        return new ImplProductLocation(stockRepostitory, productLocationMapper);
    }
}