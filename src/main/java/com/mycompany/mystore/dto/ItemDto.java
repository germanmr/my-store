package com.mycompany.mystore.dto;

import java.util.Objects;

public class ItemDto {

    private final Integer id;
    private final String description;

    public ItemDto(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDto)) return false;
        ItemDto itemDto = (ItemDto) o;
        return id == itemDto.id &&
                Objects.equals(description, itemDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

