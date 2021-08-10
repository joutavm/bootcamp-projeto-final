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

import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.*;
import com.mercadolibre.joao_magalhaes.domain.repository.*;
import com.mercadolibre.joao_magalhaes.domain.service.*;
import com.mercadolibre.joao_magalhaes.domain.service.impl.*;
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
    public UpdateStockService updateStockService(RetrieveSectionService retrieveSectionService, StockViewMapper stockViewMapper, FindOrderService findOrderService, FindProductService findProductService, StockFormMapper stockFormMapper){
        return new ImplUpdateStock(retrieveSectionService, stockViewMapper, findOrderService, findProductService,stockFormMapper);
    }

    @Bean
    public FindOrderService findOrderService(OrderRepository orderRepository){
        return new ImplFindOrder(orderRepository);

    }
    @Bean
    public RetrieveProductService retrieveProductService(FindProductService findProductService, ProductViewMapper productViewMapper){
        return new ImplRetrieveProductService(productViewMapper, findProductService);
    }

    @Bean
    public FindProductInStockService findProductInStockService(StockRepostitory stockRepostitory){
        return new ImplFindProductInStockService(stockRepostitory);
    }

    @Bean
    public CreateBuyOrderService createBuyOrderService(FindProductInStockService findProductInStockService,
                                                       FindProductService findProductService, BuyOrderFormMapper buyOrderFormMapper, BuyOrderRepository buyOrderRepository){
        return new ImplBuyOrderService(findProductInStockService,findProductService, buyOrderFormMapper, buyOrderRepository);
    }

    @Bean
    public FindBuyOrderById findBuyOrderById(BuyOrderRepository buyOrderRepository){
        return new ImplFindBuyOrderById(buyOrderRepository);
    }

    @Bean
    public GetBuyOrderProductsService getBuyOrderProductsService(FindBuyOrderById findBuyOrderById,
                                                                 BuyOrderProductsMapper buyOrderProductsMapper){
        return new ImplGetBuyOrderProducts(findBuyOrderById, buyOrderProductsMapper);
    }

    @Bean
    public UpdateOrderService updateOrderService(FindBuyOrderById findBuyOrderById, BuyOrderUpdateMapper buyOrderUpdateMapper, FindProductInStockService findProductInStockService){
        return new ImplUpdateOrderService(findBuyOrderById,buyOrderUpdateMapper, findProductInStockService);
    }

    @Bean
    public ProductLocationService productLocationService(StockRepostitory stockRepostitory, ProductLocationMapper productLocationMapper){
        return new ImplProductLocation(stockRepostitory, productLocationMapper);
    }
}