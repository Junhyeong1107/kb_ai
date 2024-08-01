package com.example.sanback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sanback.entity.User;
import com.example.sanback.repository.UserRepository;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String userid, String username, String password) {
        User user = new User();
        user.setUserid(userid);
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User findByUserid(String userid) {
        return userRepository.findByUserid(userid).orElse(null);
    }

    public boolean validateUser(String userid, String password) {
        User user = findByUserid(userid);
        return user != null && user.getPassword().equals(password);
    }
}

