package com.mycompany.mystore.model;

import java.math.BigInteger;
import java.util.Objects;

public class Item {

    private final Integer id;
    private final String description;
    private final BigInteger quantity;

    public Item(Integer id, String description, BigInteger quantity) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(description, item.description) &&
                Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, quantity);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
