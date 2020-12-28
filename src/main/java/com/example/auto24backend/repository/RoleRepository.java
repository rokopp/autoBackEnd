package com.example.auto24backend.repository;

import com.example.auto24backend.database.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Long, Role> {

    Role findByRole(String role);
}
