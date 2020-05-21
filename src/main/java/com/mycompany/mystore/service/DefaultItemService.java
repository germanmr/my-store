package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.exceptions.NoItemFoundException;
import com.mycompany.mystore.exceptions.NoStockFoundException;
import com.mycompany.mystore.repository.ItemRepository;
import com.mycompany.mystore.service.function.StockValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultItemService implements ItemService {

    private final ItemRepository itemRepository;
    private final Set<ItemDto> itemDtos;
    private final StockValidator stockValidator;


    @Inject
    public DefaultItemService(@Nonnull ItemRepository itemRepository, StockValidator stockValidator) {
        requireNonNull(itemRepository);
        requireNonNull(stockValidator);
        this.itemRepository = itemRepository;
        this.stockValidator = stockValidator;

        Set<ItemDto> itemDtos = new HashSet<>();
        itemDtos.add(new ItemDto(1, "KEYBOARD"));
        this.itemDtos = itemDtos;

    }

    @Override
    public ItemDto getById(@Nonnull Integer itemId) {
        requireNonNull(itemId);

        ItemDto itemDto = itemDtos.stream()
                .filter(it -> it.getId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoItemFoundException());

        // Validate stock of returned item
        boolean thereIs = stockValidator.apply(itemDto);

        if (!thereIs) {
            throw new NoStockFoundException();
        }


        return itemDto;

    }

    @Override
    public Set<ItemDto> getAll() {
        return itemDtos;
    }

    @Override
    public Set<ItemDto> getByFilter(@Nonnull String filter) {
        requireNonNull(filter);

        itemDtos.stream()
                .findAny()
                .orElseThrow(() -> new NoItemFoundException());

        return itemDtos;
    }

}
