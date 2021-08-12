package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.mapper.DueDateMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;
import com.mercadolibre.projeto_final.domain.exceptions.ApiException;
import com.mercadolibre.projeto_final.domain.model.CategoryProductEnum;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.service.DueDateService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ImplDueDate implements DueDateService {

    private final StockService stockService;
    private final DueDateMapper dueDateMapper;

    @Override
    public List<DueDateView> findByDueDate(int days) {
        LocalDate date = convertDays(days);
        List<Stock> stockList = stockService.findByDueDate(date);
        return stockList.stream().map(dueDateMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<DueDateView> findByDueDateSorted(int days, String category, String order) {
        List<DueDateView> dueDateViewList = findByDueDate(days);

        Comparator<DueDateView> comparator = Comparator.comparing(
                e -> LocalDate.parse(e.getDueDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        if(order.toLowerCase(Locale.ROOT).equals("desc"))
            comparator = comparator.reversed();

        Stream<DueDateView> dueDateViewStream = dueDateViewList.stream().sorted(comparator);


        return filterByCategory(dueDateViewStream, category).collect(Collectors.toList());
    }



    private Stream<DueDateView> filterByCategory(Stream<DueDateView> stream, String category){
        category = category.toLowerCase(Locale.ROOT);

        if (category.equals("fs"))
            return stream.filter(e -> e.getCategory().toLowerCase(Locale.ROOT)
                    .equals(CategoryProductEnum.FS.toString().toLowerCase(Locale.ROOT)));

        if (category.equals("rf"))
            return stream.filter(e -> e.getCategory().toLowerCase(Locale.ROOT)
                    .equals(CategoryProductEnum.RF.toString().toLowerCase(Locale.ROOT)));

        if (category.equals("ff"))
            return stream.filter(e -> e.getCategory().toLowerCase(Locale.ROOT)
                    .equals(CategoryProductEnum.FF.toString().toLowerCase(Locale.ROOT)));
        return stream;



    }


    private void validateDays(int days){
        if(days<0){
            throw new ApiException("BAD REQUEST", "Days can't be negative!", 403);
        }
    }

    private LocalDate convertDays(int days){
        validateDays(days);
        return LocalDate.now().plusDays(days);
    }

}
