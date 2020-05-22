package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.ItemDto;
import com.mycompany.mystore.endpoint.base.CrudEndPoint;

public interface Item extends CrudEndPoint<ItemDto, Integer> {

}
