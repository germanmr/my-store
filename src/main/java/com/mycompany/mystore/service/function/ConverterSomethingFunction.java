package com.mycompany.mystore.service.function;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.model.Item;

import java.util.function.Function;

/**
 * We will use this function:
 * <br> either convert one thing to another
 * <br>2)  different outcome than income!</br>
 */
public class ConverterSomethingFunction implements Function<ItemDto, Item> {

//    private final Set<Item> dummyItems;
//
//    public StockValidator() {
//        this.dummyItems = new HashSet<>();
//        dummyItems.add(new Item(1, "KEYBOARD", BigInteger.TEN));
//        dummyItems.add(new Item(2, "MONITOR", BigInteger.ONE));
//        dummyItems.add(new Item(2, "RAM", BigInteger.ZERO));
//    }

    @Override
    public Item apply(ItemDto itemDto) {

//        Item itemReturned = dummyItems.stream()
//                .filter(item -> itemDto.getId().equals(item.getId()) && (item.getQuantity().compareTo(itemDto.getQuantity()) == 1))
//                .findAny()
//                .orElseThrow(NoStockFoundException::new);
        return null;
    }
}
