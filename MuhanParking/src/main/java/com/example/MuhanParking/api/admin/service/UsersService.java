package com.example.MuhanParking.api.admin.service;

import com.example.MuhanParking.model.User;
import com.example.MuhanParking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private UserRepository userRepository;
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        System.out.println(userRepository);
        return userRepository.findAll();
    }
}
