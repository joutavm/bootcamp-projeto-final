package com.mercadolibre.projeto_final.application.config;

import com.mercadolibre.projeto_final.domain.dtos.mapper.*;
import com.mercadolibre.projeto_final.domain.repository.OrderRepository;
import com.mercadolibre.projeto_final.domain.repository.ProductRepository;
import com.mercadolibre.projeto_final.domain.repository.SectionRepository;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import com.mercadolibre.projeto_final.domain.service.CreateOrderService;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import com.mercadolibre.projeto_final.domain.service.ProductLocationService;
import com.mercadolibre.projeto_final.domain.service.RetrieveSectionService;
import com.mercadolibre.projeto_final.domain.service.impl.ImplCreateOrder;
import com.mercadolibre.projeto_final.domain.service.impl.ImplFindProduct;
import com.mercadolibre.projeto_final.domain.service.impl.ImplProductLocation;
import com.mercadolibre.projeto_final.domain.service.impl.ImplRetrieveSectionService;

import com.mercadolibre.projeto_final.domain.repository.*;
import com.mercadolibre.projeto_final.domain.service.*;
import com.mercadolibre.projeto_final.domain.service.impl.*;
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
    public ProductLocationService productLocationService(StockRepostitory stockRepostitory, ProductLocationMapper productLocationMapper, ProductInWarehouseMapper productInWarehouseMapper, StocksByProductInWarehousesMapper stocksByProductInWarehousesMapper){
        return new ImplProductLocation(stockRepostitory, productLocationMapper, productInWarehouseMapper, stocksByProductInWarehousesMapper);
    }

    @Bean
    public DueDateService dueDateService(StockRepostitory stockRepostitory, DueDateMapper dueDateMapper){
        return new ImplDueDate(stockRepostitory, dueDateMapper);
    }

    @Bean
    public CompleteBuyOrderService completeBuyOrderService(BuyOrderService buyOrderService, FindProductInStockService findProductInStockService, BuyOrderCompletedMapper buyOrderCompletedMapper){
        return new ImplCompleteBuyOrderService(buyOrderService,findProductInStockService,buyOrderCompletedMapper);
    }
}