package com.mycompany.mystore.dto;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movie", propOrder = { "id", "name" })
public class ClientDto {

    private final long id;
    private final String name;

    /**
     * @param id
     * @param name
     */
    public ClientDto(@Nonnull long id,
                     @Nonnull String name) {
        this.id = requireNonNull(id);
        this.name = requireNonNull(name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientDto)) return false;
        ClientDto clientDto = (ClientDto) o;
        return id == clientDto.id &&
                Objects.equals(name, clientDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
