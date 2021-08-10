package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductInWarehouseMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductLocationMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StocksByProductInWarehousesMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductLocationView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductWithIdWarehouseView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductInWarehouseSqlView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.repository.OrderRepository;
import com.mercadolibre.joao_magalhaes.domain.repository.StockRepostitory;
import com.mercadolibre.joao_magalhaes.domain.service.ProductLocationService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ImplProductLocation implements ProductLocationService {

    private final StockRepostitory stockRepostitory;
    private final ProductLocationMapper productLocationMapper;
    private final ProductInWarehouseMapper productInWarehouseMapper;
    private final StocksByProductInWarehousesMapper stocksByProductInWarehousesMapper;

    @Override
    public List<ProductLocationView> findByStockList(Long id) throws ItemNotFoundException {
        List<ProductLocationSqlView> productLocationList = stockRepostitory.findByStockList(id);
        if(productLocationList.isEmpty()){
            throw new ItemNotFoundException("Not Found", "List of Products is empty!", 404);
        }

        return productLocationList.stream().map(e -> productLocationMapper.map(e)).collect(Collectors.toList());
    }

    @Override
    public List<ProductLocationView> findByStockSorted(Long id, Character order) {
        Comparator<ProductLocationView> comparator;

        if (order.toString().toUpperCase(Locale.ROOT).equals("F")) {
            comparator = Comparator.comparing(e -> LocalDate.parse(e.getDueDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        } else {
            comparator = Comparator.comparing(ProductLocationView::getCurrentQuantity);
        }

        return findByStockList(id).stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public ProductWithIdWarehouseView findByWarehouse(Long id) throws ItemNotFoundException {
        List<ProductInWarehouseSqlView> productInWarehouseSqlViews = stockRepostitory.findByWarehouse(id);
        if(productInWarehouseSqlViews.isEmpty()){
            throw new ItemNotFoundException("Not Found", "List of Products is empty!", 404);
        }
        List<ProductInWarehouseView> list = productInWarehouseSqlViews.stream().map(productInWarehouseMapper::map).collect(Collectors.toList());

        return stocksByProductInWarehousesMapper.map(list, id);
    }


}
