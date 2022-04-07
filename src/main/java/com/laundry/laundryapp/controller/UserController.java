package com.laundry.laundryapp.controller;

import com.laundry.laundryapp.model.User;
import com.laundry.laundryapp.model.UserLoginModel;
import com.laundry.laundryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public List order(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public Object userLogin(@RequestBody UserLoginModel userLoginModel) throws ExecutionException, InterruptedException {
        return userService.loginUser(userLoginModel);
    }

    @GetMapping("/info")
    public Object getUserData(@RequestParam String user_id) throws ExecutionException, InterruptedException {
        return userService.getUser(user_id);
    }
}
