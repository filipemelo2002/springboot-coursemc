package com.example.coursemc.domain;

import com.example.coursemc.domain.enums.PaymentState;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable {

    private Integer id;
    private PaymentState state;

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
