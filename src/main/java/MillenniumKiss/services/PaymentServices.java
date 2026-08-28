package MillenniumKiss.services;

import java.util.List;

import MillenniumKiss.entity.Payment;

public interface PaymentServices {

    Payment savePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    void deletePayment(Long id);

}
