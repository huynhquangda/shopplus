package com.devcamp.shopplus.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.shopplus.Entity.Customer;
import com.devcamp.shopplus.Entity.Payment;
import com.devcamp.shopplus.Repository.CustomerRepository;
import com.devcamp.shopplus.Repository.PaymentRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PaymentController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/payment")
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @GetMapping("/payment/{id}")
    public Payment getPaymentById(@PathVariable("id") long id) {
        return paymentRepository.findById(id).get();
    }

    @PostMapping("/payment/{id}")
    public ResponseEntity<Payment> createPayment(@PathVariable("id") long id, @RequestBody Payment pPayment) {
        try {
            Optional<Customer> customerData = customerRepository.findById(id);
            Payment paymentData = new Payment();
            paymentData.setAmmount(pPayment.getAmmount());
            paymentData.setCheckNumber(pPayment.getCheckNumber());
            paymentData.setPaymentDate(new Date());
            paymentData.setCustomer(customerData.get());
            return new ResponseEntity<>(paymentRepository.save(paymentData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("payment/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") long id, @RequestBody Payment pPayment) {
        try {
            Optional<Payment> paymentData = paymentRepository.findById(id);
            if (paymentData.isPresent()) {
                paymentData.get().setAmmount(pPayment.getAmmount());
                paymentData.get().setCheckNumber(pPayment.getCheckNumber());
                paymentData.get().setPaymentDate(new Date());

                return new ResponseEntity<>(paymentRepository.save(paymentData.get()), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/payment/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable("id") long id) {
        paymentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
