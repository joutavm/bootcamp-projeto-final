package com.mercadolibre.joao_magalhaes.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderTest {

    @Test
    public void shouldCreateAPurchaseOrderThenReturnDateOrderStatusProductList(){
        Product product = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProduct.FS);
        Product product2 = new Product(Long.valueOf(1), "Pizza", 2.0, CategoryProduct.FS);

        OrderStatus orderStatus = new OrderStatus();
        PurchaseOrder purchaseOrder = new PurchaseOrder(1L, LocalDate.of(2021,3,12), orderStatus, List.of(product, product2));

        assertEquals("Cheese", purchaseOrder.getProductList().get(0).getName());
        assertEquals(LocalDate.of(2021,3,12), purchaseOrder.getDate());
        assertEquals(1L, purchaseOrder.getId());
        assertEquals(orderStatus, purchaseOrder.getOrderStatus());
    }

}