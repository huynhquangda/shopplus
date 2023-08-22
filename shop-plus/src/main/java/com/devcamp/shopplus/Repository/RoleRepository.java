package com.devcamp.shopplus.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Model.ERole;
import com.devcamp.shopplus.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
