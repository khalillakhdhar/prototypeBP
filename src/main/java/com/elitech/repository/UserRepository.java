package com.elitech.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elitech.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
@Query("SELECT u FROM User u WHERE u.email LIKE %:symbol%")
List<User> findByEmailContainingSymbol(String symbol);
Page<User> findAll(Pageable pageable);

}
