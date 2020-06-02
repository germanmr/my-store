package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.service.base.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface ItemService extends CrudService<ItemDto, Integer> {

}
