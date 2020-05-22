package com.mycompany.mystore.repository;

import com.mycompany.mystore.model.Item;
import com.mycompany.mystore.model.Order;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataRedisTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisOrderRepositoryTest {

    @Autowired
    OrderRepository repository;

    @Test
    public void testAdd() {
        Order order = new Order(1L, "80010121098", new Date());
        order.addItem(new Item(1L, "KEYBOARD", BigInteger.ZERO));
        order.addItem(new Item(2L, "MOUSE", BigInteger.ONE));
        order.addItem(new Item(3L, "MONITOR", BigInteger.TEN));
        order = (Order) repository.save(order);
        Assert.assertNotNull(order);
    }

    @Test
    public void testFindByItems() {
        List<Order> orders = repository.findByItemsId(3L);
        Assert.assertEquals(1, orders.size());
        Order order = orders.get(0);
        Assert.assertNotNull(order);
        Assert.assertEquals(1, order.getId().longValue());
    }

    @Test
    public void testFindByExternal() {
        Order order = repository.findByExternalId("80010121098");
        Assert.assertNotNull(order);
        Assert.assertEquals(1, order.getId().longValue());
    }
}