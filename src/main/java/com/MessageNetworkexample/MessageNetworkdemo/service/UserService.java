package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id,User user);
    void deleteById(Long id);
    User getOneUserByUsername(String username);


}
