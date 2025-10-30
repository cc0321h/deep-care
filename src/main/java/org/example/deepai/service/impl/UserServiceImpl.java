package org.example.deepai.service.impl;

import java.util.List;

import org.example.deepai.dto.UserLoginDTO;
import org.example.deepai.entity.User;
import org.example.deepai.mapper.UserMapper;
import org.example.deepai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public int insertUser(User user) {
        String passwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(passwd);
        return userMapper.insert(user);
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        User user = userMapper.selectOne(
            new QueryWrapper<User>().eq("username", userLoginDTO.getUsername())
        );
        if (user == null) {
            throw new RuntimeException("User not found");
        } else{
            System.out.println("username:" + userLoginDTO.getUsername());
            System.out.println("passwd:" + userLoginDTO.getpassword());
            System.out.println("username:" + user.getUsername());
            System.out.println("passwd:" + user.getPassword());
        }

        String passwd = DigestUtils.md5DigestAsHex(userLoginDTO.getpassword().getBytes());
        System.out.println(passwd);
        if (!user.getPassword().equals(passwd)) {
            throw new RuntimeException("Invalid credentials");
        }
        System.out.println("login success");
        user.setPassword(null);
        return user;

    }


    
}
