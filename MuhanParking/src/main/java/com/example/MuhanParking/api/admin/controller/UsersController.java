package com.example.MuhanParking.api.admin.controller;

import com.example.MuhanParking.model.User;
import com.example.MuhanParking.api.admin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/api/v1/admin/users")
    public List<User> getAllUsers() {
        System.out.println(usersService.getAllUsers());
        return usersService.getAllUsers();
    }

}
