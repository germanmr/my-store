package com.mycompany.mystore.dto;

import javax.annotation.Nonnull;
import java.util.Date;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class OrderDto {

    private Long id;
    private String name;
    private Date date;

    /**
     * @param id
     * @param name
     */
    public OrderDto(@Nonnull long id,
                    @Nonnull String name) {
        this.id = requireNonNull(id);
        this.name = requireNonNull(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return id == orderDto.id &&
                Objects.equals(name, orderDto.name) &&
                Objects.equals(date, orderDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
