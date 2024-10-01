package com.example.PaymentService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    private PaymentService paymentService = new PaymentService();

    @Test
    @DisplayName("Test that a payment is correct")
    void processPayment() {
        PaymentRequestDto validRequest = new PaymentRequestDto("1234567812345678", "123", "12/25", 100.00);
        PaymentResponseDto response = paymentService.processPayment(validRequest);
        assertEquals("Pago realizado con éxito", response.getMessage());
        assertEquals(true, response.isSuccess());
    }
    @Test
    @DisplayName("Test that a payment fails")
    void proccesFail(){
        PaymentRequestDto invalidRequest = new PaymentRequestDto("1234", "12", "12/25", 100.00);
        PaymentResponseDto response = paymentService.processPayment(invalidRequest);
        assertEquals("Pago fallido: datos de tarjeta incorrectos", response.getMessage());
    }
}