package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.service.ItemService;
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
@RequestMapping("item")
public class ItemsEndpoint implements Items {

    private final ItemService itemService;

    @Inject
    public ItemsEndpoint(@Nonnull ItemService itemService) {
        this.itemService = requireNonNull(itemService);
    }

    @Override
    @GetMapping("/{id}")
    public ItemDto get(@Nonnull @PathVariable("itemId") Integer id) {
        return itemService.getById(requireNonNull(id));
    }

    @Override
    @GetMapping("/all")
    public Set<ItemDto> getAll() {
        return itemService.getAll();
    }

    @Override
    @GetMapping("/filter/{filter}")
    public Set<ItemDto> getByName(@NotEmpty @PathVariable("filter") String filter) {
        return itemService.getByFilter(requireNonNull(filter));
    }

}
