package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.OrderDto;
import com.mycompany.mystore.exceptions.NoOrderFoundException;
import com.mycompany.mystore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final Set<OrderDto> orderDtos;

    @Inject
    public DefaultOrderService(@Nonnull OrderRepository orderRepository) {
        requireNonNull(orderRepository);
        this.orderRepository = orderRepository;

        Set<OrderDto> orderDtos = new HashSet<>();
        orderDtos.add(new OrderDto(1, "German"));
        this.orderDtos = orderDtos;

    }

    @Override
    public OrderDto getById(@Nonnull Long orderId) {
        requireNonNull(orderId);

        OrderDto orderDto = null;
        orderDto = orderDtos.stream()
                .filter(o -> o.getId() == orderId)
                .findFirst()
                .orElseThrow(() -> new NoOrderFoundException());

        return orderDto;
    }

    @Override
    public Set<OrderDto> getAll() {
        return orderDtos;
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
