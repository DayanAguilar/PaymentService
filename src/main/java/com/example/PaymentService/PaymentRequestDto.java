package com.example.PaymentService;

import java.util.Objects;

public class PaymentRequestDto {
    private String cardNumber;
    private String cvv;
    private String expirationDate;
    private double amount;


    public PaymentRequestDto(String cardNumber, String cvv, String expirationDate, double amount) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void validate() throws IllegalArgumentException {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("El número de tarjeta es obligatorio.");
        }
        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos.");
        }

        if (cvv == null || cvv.isEmpty()) {
            throw new IllegalArgumentException("El CVV es obligatorio.");
        }
        if (cvv.length() != 3 || !cvv.matches("\\d+")) {
            throw new IllegalArgumentException("El CVV debe tener 3 dígitos.");
        }

        if (expirationDate == null || expirationDate.isEmpty()) {
            throw new IllegalArgumentException("La fecha de expiración es obligatoria.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
    }
}
