package com.mycompany.mystore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * This class represents the history of values for an Item
 */
@RedisHash("historic")
public class Historic {
    @Id
    private Long id;
    private String observations;
    private Date date;
    private BigDecimal amount;

    /**
     * Relation with the {@link Item}
     */
    @Indexed
    private Long fromItemId;
    @Indexed
    private Long toItemId;

    public Historic(Long id, String observations, BigDecimal amount, Date date, Long fromItemId, Long toItemId) {
        this.id = id;
        this.observations = observations;
        this.amount = amount;
        this.date = date;
        this.fromItemId = fromItemId;
        this.toItemId = toItemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getFromItemId() {
        return fromItemId;
    }

    public void setFromItemId(Long fromItemId) {
        this.fromItemId = fromItemId;
    }

    public Long getToItemId() {
        return toItemId;
    }

    public void setToItemId(Long toItemId) {
        this.toItemId = toItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Historic)) return false;
        Historic historic = (Historic) o;
        return Objects.equals(id, historic.id) &&
                Objects.equals(observations, historic.observations) &&
                Objects.equals(date, historic.date) &&
                Objects.equals(amount, historic.amount) &&
                Objects.equals(fromItemId, historic.fromItemId) &&
                Objects.equals(toItemId, historic.toItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, observations, date, amount, fromItemId, toItemId);
    }

    @Override
    public String toString() {
        return "Historic{" +
                "id=" + id +
                ", observations='" + observations + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", fromItemId=" + fromItemId +
                ", toItemId=" + toItemId +
                '}';
    }
}