package com.example.coursemc.domain.enums;

public enum PaymentState {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int code;

    private String description;

    private PaymentState(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentState toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (PaymentState x : PaymentState.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid ID: "+code);
    }
}
