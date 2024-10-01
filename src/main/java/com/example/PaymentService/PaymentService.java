package com.example.PaymentService;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentResponseDto processPayment(PaymentRequestDto request) {
        request.validate();

        if (isValidCard(request.getCardNumber(), request.getCvv(), request.getExpirationDate())) {
            return new PaymentResponseDto("Pago realizado con éxito", true);
        } else {
            return new PaymentResponseDto("Pago fallido: datos de tarjeta incorrectos", false);
        }
    }

    private boolean isValidCard(String cardNumber, String cvv, String expirationDate) {
        return cardNumber.length() == 16 && cvv.length() == 3; // Ejemplo simple
    }
}
