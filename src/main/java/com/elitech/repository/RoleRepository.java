package com.elitech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
