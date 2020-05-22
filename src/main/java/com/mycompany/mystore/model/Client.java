package com.mycompany.mystore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Objects;

@RedisHash("client")
public class Client {
    @Id
    private Long id;
    @Indexed
    private String externalId;
    private String name;

    public Client(Long id, String externalId, String name) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(externalId, client.externalId) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", externalId='" + externalId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}