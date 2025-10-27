package org.example.deepai.service;

import java.util.List;

import org.example.deepai.DTO.UserLoginDTO;
import org.example.deepai.entity.User;

public interface UserService{

    User getUserById(int id);

    List<User> getAllUsers();

    int insertUser(User user);

    User login(UserLoginDTO userLoginDTO);


}
