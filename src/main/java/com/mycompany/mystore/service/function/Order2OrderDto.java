package com.mycompany.mystore.service.function;

import com.mycompany.mystore.dto.ClientDto;
import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.dto.OrderDto;
import com.mycompany.mystore.model.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.function.Function;

/**
 * We will use this function:
 * <br> either convert one thing to another
 * <br>2)  different outcome than income!</br>
 */
@Component
public class Order2OrderDto implements Function<Order, OrderDto> {


    @Override
    public OrderDto apply(Order order) {

        Long id = order.getId();

        // TODO use the other converters here!!
        ClientDto clientDto = null;
        Set<ItemDto> itemsDto = null;
        Date date = new Date();
        return new OrderDto(id, clientDto, itemsDto, date);

    }
}
