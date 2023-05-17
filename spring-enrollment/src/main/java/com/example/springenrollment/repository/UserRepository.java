package com.example.springenrollment.repository;

import com.example.springenrollment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
