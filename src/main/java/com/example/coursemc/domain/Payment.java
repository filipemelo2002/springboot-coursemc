package com.example.coursemc.domain;

import com.example.coursemc.domain.enums.PaymentState;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

    @Id
    private Integer id;
    private Integer state;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="order_id")
    @MapsId
    private ClientOrder clientOrder;

    public Payment() {

    }

    public Payment(Integer id, PaymentState state, ClientOrder clientOrder) {
        this.id = id;
        this.state = state.getCode();
        this.clientOrder = clientOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentState getState() {
        return PaymentState.toEnum(this.state);
    }

    public void setState(PaymentState state) {
        this.state = state.getCode();
    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
