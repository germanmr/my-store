package com.mycompany.mystore.endpoint;

import com.mycompany.mystore.dto.OrderDto;
import com.mycompany.mystore.endpoint.base.CrudEndPoint;

public interface Order extends CrudEndPoint<OrderDto, Long> {

}
