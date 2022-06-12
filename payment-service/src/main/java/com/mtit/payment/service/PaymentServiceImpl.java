package com.mtit.payment.service;

import com.mtit.payment.entity.Payment;
import com.mtit.payment.repos.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository repository;

    @Override
    public Integer savePayment(Payment payment) {
        return repository.save(payment).getPaymentID();
    }

    @Override
    public List<Payment> getAllPayments() {
        return (List<Payment>) repository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer paymentID) {
        return repository.findById(paymentID).get();
    }

    @Override
    public void deletePayment(Integer paymentID) {
        repository.deleteById(paymentID);
    }

}
