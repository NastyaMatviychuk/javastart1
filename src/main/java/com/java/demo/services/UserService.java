package com.java.demo.services;

import com.java.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends JpaRepository<User, Integer> {
}
