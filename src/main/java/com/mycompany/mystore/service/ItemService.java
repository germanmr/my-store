package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ItemDto;

import java.util.Set;

public interface ItemService {

    ItemDto getById(Integer id);

    Set<ItemDto> getAll();

    Set<ItemDto> getByFilter(String filter);
}
