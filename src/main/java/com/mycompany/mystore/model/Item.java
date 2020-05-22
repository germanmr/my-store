package com.mycompany.mystore.model;

import org.springframework.data.redis.core.index.Indexed;

import java.math.BigInteger;
import java.util.Objects;

/**
 * This class is stored in the same structure as Order
 */
public class Item {

    @Indexed
    private Long id;
    private String description;
    private BigInteger quantity;

    public Item(Long id, String description, BigInteger quantity) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
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
