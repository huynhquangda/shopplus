
package com.devcamp.shopplus.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.FollowOrder;

public interface FollowOrderRepository extends JpaRepository<FollowOrder, Long> {
    List<FollowOrder> findByUserId(long id);

    Optional<FollowOrder> findByUserIdAndProductId(long userId, long productId);

}
