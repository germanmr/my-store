package com.mycompany.mystore.service.function;

import com.mycompany.mystore.dto.OderDto;
import com.mycompany.mystore.model.Order;

import java.util.function.Function;

/**
 * We will use this function:
 * <br> either convert one thing to another
 * <br>2)  different outcome than income!</br>
 */
public class Order2OrderDto implements Function<Order, OderDto> {

    @Override
    public OderDto apply(Order order) {
        return null;
    }
}
