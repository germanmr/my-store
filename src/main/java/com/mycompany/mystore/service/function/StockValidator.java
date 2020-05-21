package com.mycompany.mystore.service.function;

import com.mycompany.mystore.dto.ItemDto;

import java.util.function.Function;

public class StockValidator implements Function<ItemDto, Boolean> {

    @Override
    public Boolean apply(ItemDto itemDto) {
        // Verify current stock against database
        return true;
    }
}
