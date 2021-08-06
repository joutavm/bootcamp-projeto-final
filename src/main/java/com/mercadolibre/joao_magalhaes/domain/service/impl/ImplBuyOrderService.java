package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.model.CartItem;
import com.mercadolibre.joao_magalhaes.domain.repository.BuyOrderRepository;
import com.mercadolibre.joao_magalhaes.domain.service.CreateBuyOrderService;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductInStockService;

import javax.transaction.Transactional;
import java.util.List;

public class ImplBuyOrderService implements CreateBuyOrderService {

    BuyOrderRepository buyOrderRepository;
    BuyOrderFormMapper buyOrderFormMapper;
    FindProductInStockService findProductInStockService;

    @Override @Transactional
    public BuyOrderView create(BuyOrderForm buyOrderForm) {
        //Mapeia o obj json para entidade
        buyOrderForm.getProducts().stream().map( item -> {
            //Trocar nome do service, quem busca or prod é a query.
             findProductInStockService.findProductInStock(item);
            //  Try Catch com retorno que cria view.
            // Cria um map

        })


        BuyOrder buyOrder = buyOrderFormMapper.map(buyOrderForm);
        //buscar por estoque dos produtos do form dentro do banco.
        // montar o response - fazer a conta de valor total do carrinho do cara = precoProduto*quantidade.
        buyOrderRepository.save(buyOrderForm);
    }
}