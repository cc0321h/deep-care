package org.example.deepai.controller;

import java.util.List;

import org.example.deepai.dto.UserLoginDTO;
import org.example.deepai.entity.User;
import org.example.deepai.result.Result;
import org.example.deepai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result<User> getUserById(@RequestParam("id") int id) {
        return Result.success(userService.getUserById(id));
    }

    @GetMapping("/all")
    public Result<List<User>> getAllUsers() {
        return Result.success(userService.getAllUsers());
    }

    @PostMapping("/login")
    public Result<User> login(@RequestBody UserLoginDTO userLoginDTO) {
        return Result.success(userService.login(userLoginDTO));
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        int res = userService.insertUser(user);
        if(res == 0){
            return Result.error("register failed");
        }
        return Result.success();
    }
    
}
