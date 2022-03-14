package com.dosja.Dosja.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Entity
@Table(name = "Punet")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Punet extends Auditable<String> {

    @Size(min = 5, max =20,message = "Product must be between 5 and 20 characters")
    private String name;

    @DecimalMin(value = "0.0",inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal price;

    @Size(max =500,message = "Limit description characters is 500")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private InvoiceStatus status;
    public enum InvoiceStatus {
        PAID, UNPAID
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String  description) {
        this.description = description;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }


}
