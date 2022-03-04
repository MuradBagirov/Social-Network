package com.MessageNetworkexample.MessageNetworkdemo.repository;

import com.MessageNetworkexample.MessageNetworkdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
