package com.devcamp.shopplus.Controller;

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
import com.devcamp.shopplus.Model.User;
import com.devcamp.shopplus.Repository.CustomerRepository;
import com.devcamp.shopplus.Repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") long id) {
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customer/{id}")
    public ResponseEntity<Customer> createCustomer(@PathVariable("id") long id, @RequestBody Customer pCustomer) {
        try {
            Optional<User> userData = userRepository.findById(id);
            Customer customerData = new Customer();
            customerData.setAddress(pCustomer.getAddress());
            customerData.setCity(pCustomer.getCity());
            customerData.setCountry(pCustomer.getCountry());
            customerData.setCreditLimit(pCustomer.getCreditLimit());
            customerData.setFirstName(pCustomer.getFirstName());
            customerData.setLastName(pCustomer.getLastName());
            customerData.setOrders(pCustomer.getOrders());
            customerData.setPayments(pCustomer.getPayments());
            customerData.setPhoneNumber(pCustomer.getPhoneNumber());
            customerData.setPostalCode(pCustomer.getPostalCode());
            customerData.setSaleRepEmployeeNumber(pCustomer.getSaleRepEmployeeNumber());
            customerData.setState(pCustomer.getState());
            customerData.setUser(userData.get());
            return new ResponseEntity<>(customerRepository.save(customerData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer pCustomer) {
        try {
            Optional<Customer> customerData = customerRepository.findById(id);
            if (customerData.isPresent()) {
                customerData.get().setAddress(pCustomer.getAddress());
                customerData.get().setCity(pCustomer.getCity());
                customerData.get().setCountry(pCustomer.getCountry());
                customerData.get().setCreditLimit(pCustomer.getCreditLimit());
                customerData.get().setFirstName(pCustomer.getFirstName());
                customerData.get().setLastName(pCustomer.getLastName());
                // customerData.get().setOrders(pCustomer.getOrders());
                // customerData.get().setPayments(pCustomer.getPayments());
                customerData.get().setPhoneNumber(pCustomer.getPhoneNumber());
                customerData.get().setPostalCode(pCustomer.getPostalCode());
                customerData.get().setSaleRepEmployeeNumber(pCustomer.getSaleRepEmployeeNumber());
                customerData.get().setState(pCustomer.getState());
                return new ResponseEntity<>(customerRepository.save(customerData.get()), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
