package com.mycompany.mystore.dto;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class OderDto {

    private final Integer id;
    private final ClientDto clientDto;
    private final Set<ItemDto> items;
    private final Date date;

    public OderDto(Integer id, ClientDto clientDto, Set<ItemDto> items, Date date) {
        this.id = id;
        this.clientDto = clientDto;
        this.items = items;
        this.date = date;
    }

    public Integer getId() {
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
        if (!(o instanceof OderDto)) return false;
        OderDto oderDto = (OderDto) o;
        return Objects.equals(id, oderDto.id) &&
                Objects.equals(clientDto, oderDto.clientDto) &&
                Objects.equals(items, oderDto.items) &&
                Objects.equals(date, oderDto.date);
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

