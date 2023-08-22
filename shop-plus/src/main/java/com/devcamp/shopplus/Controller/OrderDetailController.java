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

import com.devcamp.shopplus.Entity.Order;
import com.devcamp.shopplus.Entity.OrderDetail;
import com.devcamp.shopplus.Entity.Product;
import com.devcamp.shopplus.Repository.OrderDetailRepository;
import com.devcamp.shopplus.Repository.OrderRepository;
import com.devcamp.shopplus.Repository.ProductRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class OrderDetailController {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/orderDetail")
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    @GetMapping("/orderDetail/{id}")
    public OrderDetail getOrderDetailById(@PathVariable("id") long id) {
        return orderDetailRepository.findById(id).get();
    }

    @PostMapping("/orderDetail/{productId}/{orderId}")
    public ResponseEntity<OrderDetail> createOrderDetail(@PathVariable("productId") long productId,
            @PathVariable("orderId") long orderId, @RequestBody OrderDetail pOrderDetail) {
        try {
            Optional<Product> productData = productRepository.findById(productId);
            Optional<Order> orderData = orderRepository.findById(orderId);
            OrderDetail orderDetailData = new OrderDetail();
            orderDetailData.setOrder(orderData.get());
            orderDetailData.setPriceEach(pOrderDetail.getPriceEach());
            orderDetailData.setProduct(productData.get());
            orderDetailData.setQuantityOrder(pOrderDetail.getQuantityOrder());
            return new ResponseEntity<>(orderDetailRepository.save(orderDetailData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/orderDetail/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable("id") long id,
            @RequestBody OrderDetail pOrderDetail) {
        try {
            Optional<OrderDetail> orderDetailData = orderDetailRepository.findById(id);
            if (orderDetailData.isPresent()) {

                orderDetailData.get().setPriceEach(pOrderDetail.getPriceEach());

                orderDetailData.get().setQuantityOrder(pOrderDetail.getQuantityOrder());
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/orderDetail/{id}")
    public ResponseEntity<OrderDetail> deleteOrderDetail(@PathVariable("id") long id) {
        orderDetailRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
