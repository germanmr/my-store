package com.mycompany.mystore.repository;

import com.mycompany.mystore.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findByExternalId(String externalId);

    List findByItemsId(Long id);

}