package com.mycompany.mystore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RedisHash("order")
public class Order {
    @Id
    private Long id;
    @Indexed
    private String externalId;
    private Date orderDate;
    private List<Item> items = new ArrayList<>();

    public Order(Long id, String externalId, Date orderDate) {
        this.id = id;
        this.externalId = externalId;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}