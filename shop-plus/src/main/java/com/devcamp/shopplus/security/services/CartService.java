package com.devcamp.shopplus.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devcamp.shopplus.Entity.Cart;
import com.devcamp.shopplus.Entity.Product;
import com.devcamp.shopplus.Model.User;
import com.devcamp.shopplus.Repository.CartRepository;
import com.devcamp.shopplus.Repository.ProductRepository;
import com.devcamp.shopplus.Repository.UserRepository;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    UserRepository userRepository;

    public Cart addToCart(long productId) {

        Product product = productRepository.findById(productId).get();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username).get();

        Optional<Cart> cartItemExit = cartRepository.findByUserIdAndProductId(user.getId(), productId);

        if (cartItemExit.isPresent()) {
            // san pham da ton tai
            Cart cartItem = cartItemExit.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItem.setTotalBill(cartItem.getQuantity() * product.getBuyPrice());
            return cartRepository.save(cartItem);

        } else {
            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setUser(user);
            cart.setQuantity(1);
            cart.setTotalBill(product.getBuyPrice());
            return cartRepository.save(cart);

        }

    }

}
