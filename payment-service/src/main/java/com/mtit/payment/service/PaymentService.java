package com.mtit.payment.service;

import com.mtit.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
    public Integer savePayment(Payment payment);

    public List<Payment> getAllPayments();
    public Payment getPaymentById(Integer paymentID);

    public void deletePayment(Integer paymentID);

}
