package com.spring.lesson3.rest_part1.repository;

import com.spring.lesson3.rest_part1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,  Integer> {
}
