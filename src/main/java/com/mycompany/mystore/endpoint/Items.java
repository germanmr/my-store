package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.ItemDto;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public interface Items {

    ItemDto get(@Nonnull int itemId);

    Set<ItemDto> getAll();

    Set<ItemDto> getByName(@NotEmpty String product);

}
