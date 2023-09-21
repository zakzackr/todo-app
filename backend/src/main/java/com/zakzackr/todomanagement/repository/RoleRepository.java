package com.zakzackr.todomanagement.repository;

import com.zakzackr.todomanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
