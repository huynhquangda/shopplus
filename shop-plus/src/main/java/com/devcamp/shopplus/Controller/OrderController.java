package com.devcamp.shopplus.Controller;

import java.util.Calendar;
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
import com.devcamp.shopplus.Entity.Order;
import com.devcamp.shopplus.Repository.CustomerRepository;
import com.devcamp.shopplus.Repository.OrderRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/order")
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable("id") long id) {
        return orderRepository.findById(id).get();
    }

    @PostMapping("/order/{id}")
    public ResponseEntity<Order> createOrder(@PathVariable("id") long id, @RequestBody Order pOrder) {
        try {
            // Tạo một đối tượng Date đại diện cho thời điểm hiện tại
            Date currentDate = new Date();

            // Sử dụng lớp Calendar để thêm 2 ngày
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DATE, 2);

            // Lấy ngày sau khi đã thêm 2 ngày
            Date requiredDate = calendar.getTime();

            // Sử dụng requiredDate để cập nhật orderData

            Optional<Customer> customerData = customerRepository.findById(id);
            Order orderData = new Order();
            orderData.setComments(pOrder.getComments());
            orderData.setOrderDate(new Date());
            orderData.setOrderDetails(pOrder.getOrderDetails());
            orderData.setRequiredDate(requiredDate);
            orderData.setShippedDate(requiredDate);
            orderData.setStatus(pOrder.getStatus());
            orderData.setCustomer(customerData.get());
            return new ResponseEntity<>(orderRepository.save(orderData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order pOrder) {
        try {
            Optional<Order> orderData = orderRepository.findById(id);
            if (orderData.isPresent()) {
                orderData.get().setComments(pOrder.getComments());
                orderData.get().setOrderDate(pOrder.getOrderDate());
                // orderData.get().setOrderDetails(pOrder.getOrderDetails());
                orderData.get().setRequiredDate(pOrder.getRequiredDate());
                orderData.get().setShippedDate(pOrder.getShippedDate());
                orderData.get().setStatus(pOrder.getStatus());
                return new ResponseEntity<>(orderRepository.save(orderData.get()), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id) {
        orderRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/order/customer/{id}")
    public List<Order> getOrderByCustomerId(@PathVariable("id") long id) {
        return orderRepository.findByCustomerId(id);
    }

}
