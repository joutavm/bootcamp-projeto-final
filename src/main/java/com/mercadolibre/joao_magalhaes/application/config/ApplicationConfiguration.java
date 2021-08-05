package com.mercadolibre.joao_magalhaes.application.config;

import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.OrderFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StockFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StockViewMapper;
import com.mercadolibre.joao_magalhaes.domain.repository.OrderRepository;
import com.mercadolibre.joao_magalhaes.domain.repository.ProductRepository;
import com.mercadolibre.joao_magalhaes.domain.repository.SectionRepository;
import com.mercadolibre.joao_magalhaes.domain.service.CreateOrderService;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import com.mercadolibre.joao_magalhaes.domain.service.RetrieveSectionService;
import com.mercadolibre.joao_magalhaes.domain.service.impl.ImplCreateOrder;
import com.mercadolibre.joao_magalhaes.domain.service.impl.ImplFindProduct;
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
            ProductRepository productRepository,
            FindProductService findProductService){
        return new ImplCreateOrder(orderRepository, stockViewMapper, orderFormMapper, retrieveSectionService, productRepository, stockFormMapper, findProductService);
    }

    @Bean
    public RetrieveSectionService retrieveSectionService(SectionRepository sectionRepository){
        return new ImplRetrieveSectionService(sectionRepository);
    }

    @Bean
    public FindProductService findProductService(ProductRepository productRepository){
        return new ImplFindProduct(productRepository);
    }

}