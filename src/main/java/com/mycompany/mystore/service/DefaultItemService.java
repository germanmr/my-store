package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.exceptions.NoItemFoundException;
import com.mycompany.mystore.repository.ItemRepository;
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

    @Inject
    public DefaultItemService(@Nonnull ItemRepository itemRepository) {
        requireNonNull(itemRepository);
        this.itemRepository = itemRepository;

        Set<ItemDto> itemDtos = new HashSet<>();
        itemDtos.add(new ItemDto(1, "KEYBOARD"));
        this.itemDtos = itemDtos;

    }

    @Override
    public ItemDto getById(@Nonnull Integer itemId) {
        requireNonNull(itemId);

        ItemDto itemDto = null;
        itemDto = itemDtos.stream()
                .filter(it -> it.getId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoItemFoundException());

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
