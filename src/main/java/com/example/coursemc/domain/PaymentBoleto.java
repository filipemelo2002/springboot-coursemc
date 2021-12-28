package com.example.coursemc.domain;

import com.example.coursemc.domain.enums.PaymentState;

import java.util.Date;

public class PaymentBoleto extends Payment{
    private Date paymentEnd;
    private Date paymentDate;

    public PaymentBoleto() {

    }

    public PaymentBoleto(Date paymentEnd, Date paymentDate) {
        this.paymentEnd = paymentEnd;
        this.paymentDate = paymentDate;
    }

    public PaymentBoleto(Integer id, PaymentState state, Order order, Date paymentEnd, Date paymentDate) {
        super(id, state, order);
        this.paymentEnd = paymentEnd;
        this.paymentDate = paymentDate;
    }

    public Date getPaymentEnd() {
        return paymentEnd;
    }

    public void setPaymentEnd(Date paymentEnd) {
        this.paymentEnd = paymentEnd;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
