package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.exceptions.NoItemFoundException;
import com.mycompany.mystore.exceptions.NoItemsFoundException;
import com.mycompany.mystore.repository.ItemRepository;
import com.mycompany.mystore.service.function.FilterCleaner;
import com.mycompany.mystore.service.validator.StockValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultItemService implements ItemService {

    private final ItemRepository itemRepository;
    private final Set<ItemDto> itemDtos;
    private final StockValidator stockValidator;
    private final FilterCleaner filterCleaner;


    @Inject
    public DefaultItemService(@Nonnull ItemRepository itemRepository, @Nonnull StockValidator stockValidator,
                              @Nonnull FilterCleaner filterCleaner) {
        requireNonNull(itemRepository);
        requireNonNull(stockValidator);
        requireNonNull(filterCleaner);
        this.itemRepository = itemRepository;
        this.stockValidator = stockValidator;
        this.filterCleaner = filterCleaner;

        Set<ItemDto> itemDtos = new HashSet<>();
        itemDtos.add(new ItemDto(1, "KEYBOARD", BigInteger.ZERO));
        this.itemDtos = itemDtos;

    }

    @Override
    public ItemDto getById(@Nonnull Integer itemId) {
        requireNonNull(itemId);

        // We search the item!
        // FIXME use data base!
        ItemDto itemDto = itemDtos.stream()
                .filter(it -> it.getId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoItemFoundException());

        // Validate stock of returned item, if not throw an exception!
        stockValidator.validate(itemDto);

        return itemDto;

    }

    @Override
    public Set<ItemDto> getAll() {
        return itemDtos;
    }

    @Override
    public Set<ItemDto> getByFilter(@Nonnull String filter) {
        requireNonNull(filter);

        // Cleaning the filter!
        String cleanedFilter = filterCleaner.apply(filter);

        itemDtos.stream()
                .filter(itemDto -> itemDto.getDescription().matches(".*" + filter + ".*"))
                .findAny()
                .orElseThrow(() -> new NoItemsFoundException());

        return itemDtos;
    }

}
