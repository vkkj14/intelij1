package com.intelij.intelij1.repository;

import com.intelij.intelij1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
