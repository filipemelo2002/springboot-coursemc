package com.example.coursemc.domain;

import com.example.coursemc.domain.enums.PaymentState;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Payment implements Serializable {

    @Id
    private Integer id;
    private PaymentState state;

    @OneToOne
    @JoinColumn(name="order_id")
    @MapsId
    private Order order;

    public Payment() {

    }

    public Payment(Integer id, PaymentState state, Order order) {
        this.id = id;
        this.state = state;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentState getState() {
        return state;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
