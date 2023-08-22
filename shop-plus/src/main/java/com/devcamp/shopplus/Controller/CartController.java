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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.shopplus.Entity.Cart;

import com.devcamp.shopplus.Repository.CartRepository;
import com.devcamp.shopplus.security.services.CartService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;

    @GetMapping("/addToCart/{productId}")
    public Cart addToCart(@PathVariable("productId") long productId) {
        return cartService.addToCart(productId);

    }

    @GetMapping("/cart")
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @GetMapping("/cart/{id}")
    public List<Cart> getCartByUserId(@PathVariable("id") long id) {
        return cartRepository.findByUserId(id);
    }

    @GetMapping("/cart/count/{id}")
    public long getCountProductIdSame(@PathVariable("id") long id) {
        List<Cart> cart = cartRepository.findByUserId(id);

        if (!cart.isEmpty()) {
            var vCount = 1;
            for (var bI = 0; bI < cart.size() - 1; bI++) {

                if (cart.get(bI).getProduct().getId() == (cart.get(bI + 1).getProduct().getId())) {
                    vCount++;
                }
            }
            return vCount;
        } else {
            return 0;
        }

    }

    @PutMapping("/cart/{id}")
    public ResponseEntity<Cart> updateQuantityCart(@PathVariable("id") long id, @RequestBody Cart pCart) {
        try {
            Optional<Cart> cartData = cartRepository.findById(id);
            cartData.get().setQuantity(pCart.getQuantity());
            cartData.get().setTotalBill(cartData.get().getProduct().getBuyPrice() * cartData.get().getQuantity());
            return new ResponseEntity<>(cartRepository.save(cartData.get()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable("id") long id) {
        cartRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
