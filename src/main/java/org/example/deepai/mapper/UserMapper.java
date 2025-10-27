package org.example.deepai.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.example.deepai.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    
}
