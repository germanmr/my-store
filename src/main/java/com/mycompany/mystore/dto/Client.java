package com.mycompany.mystore.dto;

import javax.annotation.Nonnull;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Client {

    private final long id;
    private final String name;

    /**
     * @param id
     * @param name
     */
    public Client(@Nonnull long id,
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
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
