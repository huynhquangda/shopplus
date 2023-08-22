package com.devcamp.shopplus.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.shopplus.Entity.Cart;
import com.devcamp.shopplus.Entity.FollowOrder;
import com.devcamp.shopplus.Repository.FollowOrderRepository;
import com.devcamp.shopplus.security.services.FollowService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class FollowController {
    @Autowired
    FollowOrderRepository followOrderRepository;

    @Autowired
    FollowService followService;

    @GetMapping("/addToCartFollow/{productId}")
    public FollowOrder addToCart(@PathVariable("productId") long productId) {
        return followService.addToCart(productId);

    }

    @GetMapping("/follow")
    public List<FollowOrder> getAllFollow() {
        return followOrderRepository.findAll();
    }

    @GetMapping("/follow/{id}")
    public List<FollowOrder> getCartByUserId(@PathVariable("id") long id) {
        return followOrderRepository.findByUserId(id);
    }

    @PutMapping("/follow/{id}")
    public ResponseEntity<FollowOrder> updateQuantityCart(@PathVariable("id") long id, @RequestBody FollowOrder pCart) {
        try {
            Optional<FollowOrder> cartData = followOrderRepository.findById(id);
            cartData.get().setQuantity(pCart.getQuantity());
            cartData.get().setTotalBill(cartData.get().getProduct().getBuyPrice() * cartData.get().getQuantity());
            return new ResponseEntity<>(followOrderRepository.save(cartData.get()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
