package com.mtit.payment.controller;

import com.mtit.payment.entity.Payment;
import com.mtit.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentDetails")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/savePayment")
    public ResponseEntity<String> savePayment( @RequestBody Payment payment){
        Integer id = service.savePayment(payment);
        return  new ResponseEntity<String>("Payment with '"+id+"' has been saved", HttpStatus.OK);

    }
    @GetMapping("/paymenttList")
    public ResponseEntity<List<Payment>> getAllProductDetails(){
        List<Payment> list = service.getAllPayments();
        return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);
    }

    @GetMapping("/getPaymentById/{paymentID}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentID")  Integer paymentID){
        Payment std = service.getPaymentById(paymentID);
        return new ResponseEntity<Payment>(std,HttpStatus.OK);
    }
    @PutMapping("/updatePayment/{payID}")
    public ResponseEntity<String> updatePayment( @PathVariable("paymentID") Integer paymentID,  @RequestBody Payment payment){
        Payment stdFromDb = service.getPaymentById(paymentID);
        stdFromDb.setPaymentID(payment.getPaymentID());
        stdFromDb.setPaymentName(payment.getPaymentName());
        stdFromDb.setPaymentDescription(payment.getPaymentDescription());
        stdFromDb.setPaymentAmount(payment.getPaymentAmount());
        Integer id = service.savePayment(stdFromDb);
        return new ResponseEntity<String>("Payment with '"+id+"' has been updated",HttpStatus.OK);

    }
    @DeleteMapping("deletePayment/{paymentID}")
    public ResponseEntity<String> deleteProduct(@PathVariable("paymentID") Integer paymentID){
        service.deletePayment(paymentID);
        return new ResponseEntity<String>("Payment with '"+paymentID+"' has been deleted",HttpStatus.OK);
    }
}
