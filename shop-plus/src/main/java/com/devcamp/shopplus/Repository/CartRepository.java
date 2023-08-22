package com.devcamp.shopplus.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(long id);

    Optional<Cart> findByUserIdAndProductId(long userId, long productId);

}
