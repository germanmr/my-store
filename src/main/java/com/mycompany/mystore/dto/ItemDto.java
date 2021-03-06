package com.mycompany.mystore.dto;

import java.math.BigInteger;
import java.util.Objects;

public class ItemDto {

    private final Integer id;
    private final String description;
    private final BigInteger quantity;

    public ItemDto(Integer id, String description,BigInteger quantity) {
        this.id = id;
        this.description = description;
        this.quantity=quantity;
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
        if (!(o instanceof ItemDto)) return false;
        ItemDto itemDto = (ItemDto) o;
        return Objects.equals(id, itemDto.id) &&
                Objects.equals(description, itemDto.description) &&
                Objects.equals(quantity, itemDto.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, quantity);
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

