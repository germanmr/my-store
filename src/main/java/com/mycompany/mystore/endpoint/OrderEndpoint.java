package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.OrderDto;
import com.mycompany.mystore.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("order")
public class OrderEndpoint implements Order {

    private final OrderService orderService;

    @Inject
    public OrderEndpoint(@Nonnull OrderService orderService) {
        this.orderService = requireNonNull(orderService);
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi from My Store Restful API!";
    }

    @Override
    @GetMapping("/{id}")
    public OrderDto get(@Nonnull @PathVariable("id") Long orderId) {
        return orderService.getById(requireNonNull(orderId));
    }

    @Override
    @GetMapping("/all")
    public Set<OrderDto> getAll() {
        return orderService.getAll();
    }

    @Override
    @GetMapping("/filter/{filter}")
    public Set<OrderDto> getByName(@NotEmpty @PathVariable("filter") String filter) {
        return orderService.getByFilter(requireNonNull(filter));
    }

}
