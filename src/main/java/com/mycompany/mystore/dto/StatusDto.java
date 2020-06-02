package com.mycompany.mystore.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status", propOrder = {"status", "data"})
public class StatusDto {

    private String status;
    private EmployeeDto data;

    public StatusDto() {
    }

    public StatusDto(String status, EmployeeDto data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeDto getData() {
        return data;
    }

    public void setData(EmployeeDto data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatusDto)) return false;
        StatusDto statusDto = (StatusDto) o;
        return Objects.equals(status, statusDto.status) &&
                Objects.equals(data, statusDto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data);
    }

    @Override
    public String toString() {
        return "StatusDto{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
