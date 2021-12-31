package com.example.coursemc.domain;

import com.example.coursemc.domain.enums.PaymentState;

import javax.persistence.Entity;

@Entity
public class PaymentCard extends Payment{
    private Integer installmentsCount;

    public PaymentCard() {

    }

    public PaymentCard(Integer installmentsCount) {
        this.installmentsCount = installmentsCount;
    }

    public PaymentCard(Integer id, PaymentState state, ClientOrder clientOrder, Integer installmentsCount) {
        super(id, state, clientOrder);
        this.installmentsCount = installmentsCount;
    }

    public Integer getInstallmentsCount() {
        return installmentsCount;
    }

    public void setInstallmentsCount(Integer installmentsCount) {
        this.installmentsCount = installmentsCount;
    }
}
