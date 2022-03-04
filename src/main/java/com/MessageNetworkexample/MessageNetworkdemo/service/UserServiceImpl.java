package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.User;
import com.MessageNetworkexample.MessageNetworkdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User file_not_found = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
        return file_not_found;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user1 = new User();
            user1.setId(user.getId());
            user1.setPassword(user.getPassword());
            user1.setUserName(user.getUserName());
            userRepository.save(user1);
            return user1;
        } else return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User getOneUserByUsername(String username){
        return userRepository.findByUserName(username);
    }

}
