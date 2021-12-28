package com.example.coursemc.domain;

import com.example.coursemc.domain.enums.PaymentState;

public class PaymentCard extends Payment{
    private Integer installmentsCount;

    public PaymentCard() {

    }

    public PaymentCard(Integer installmentsCount) {
        this.installmentsCount = installmentsCount;
    }

    public PaymentCard(Integer id, PaymentState state, Order order, Integer installmentsCount) {
        super(id, state, order);
        this.installmentsCount = installmentsCount;
    }

    public Integer getInstallmentsCount() {
        return installmentsCount;
    }

    public void setInstallmentsCount(Integer installmentsCount) {
        this.installmentsCount = installmentsCount;
    }
}
