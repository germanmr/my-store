package com.mycompany.mystore.dto;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class OrderDto {

    private final Long id;
    private final ClientDto clientDto;
    private final Set<ItemDto> items;
    private final Date date;

    public OrderDto(Long id, ClientDto clientDto, Set<ItemDto> items, Date date) {
        this.id = id;
        this.clientDto = clientDto;
        this.items = items;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public Set<ItemDto> getItemDto() {
        return items;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) &&
                Objects.equals(clientDto, orderDto.clientDto) &&
                Objects.equals(items, orderDto.items) &&
                Objects.equals(date, orderDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientDto, items, date);
    }

    @Override
    public String toString() {
        return "OderDto{" +
                "id=" + id +
                ", clientDto=" + clientDto +
                ", items=" + items +
                ", date=" + date +
                '}';
    }
}

