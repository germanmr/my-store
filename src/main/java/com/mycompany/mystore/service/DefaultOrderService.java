package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;
import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.dto.OrderDto;
import com.mycompany.mystore.exceptions.NoOrderFoundException;
import com.mycompany.mystore.model.Item;
import com.mycompany.mystore.model.Order;
import com.mycompany.mystore.repository.OrderRepository;
import com.mycompany.mystore.service.function.Order2OrderDto;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final Set<OrderDto> orderDtos;
    private final Order2OrderDto order2OrderDto;

    @Inject
    public DefaultOrderService(@Nonnull OrderRepository orderRepository,
                               @Nonnull Order2OrderDto order2OrderDto) {
        requireNonNull(orderRepository);
        requireNonNull(order2OrderDto);
        this.orderRepository = orderRepository;
        this.order2OrderDto = order2OrderDto;

        ClientDto clientDto = new ClientDto(1L, "German");
        Set<ItemDto> itemsDto = new HashSet<>();
        itemsDto.add(new ItemDto(1, "KEYBOARD", BigInteger.ZERO));

        Set<OrderDto> orderDtos = new HashSet<>();
        orderDtos.add(new OrderDto(1L, clientDto, itemsDto, new Date()));
        this.orderDtos = orderDtos;

        // We create an order
        //for (Long i = new Long(1); i < 1000000; i++) {
        Long id = 1L;
        Order order = new Order(id, "80010121098", new Date());
        order.addItem(new Item(1L, "KEYBOARD", BigInteger.ZERO));
        order.addItem(new Item(2L, "MOUSE", BigInteger.ONE));
        order.addItem(new Item(3L, "MONITOR", BigInteger.TEN));
        order = (Order) orderRepository.save(order);
        //}

    }

    @Override
    public OrderDto getById(@Nonnull Long orderId) {
        requireNonNull(orderId);

        // Get info from Redis!
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new NoOrderFoundException(orderId));

        OrderDto orderDto = order2OrderDto.apply(order);

        return orderDto;
    }

    @Override
    public Set<OrderDto> getAll() {

        // From actual repository!
        Set<OrderDto> orders = new HashSet<>();
        orderRepository.findAll()
                .forEach(o -> orders.add(order2OrderDto.apply(o)));

        return orders;

    }

    @Override
    public Set<OrderDto> getByFilter(@Nonnull String filter) {
        requireNonNull(filter);

        orderDtos.stream()
                .findAny()
                .orElseThrow(() -> new NoOrderFoundException());

        return orderDtos;
    }

}
