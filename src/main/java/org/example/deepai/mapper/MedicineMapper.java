package org.example.deepai.mapper;

import org.example.deepai.entity.Medicine;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 药品Mapper接口
 * 使用MyBatis-Plus实现数据库操作
 */
@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {
    
    // BaseMapper已经提供了基本的CRUD操作
    // 这里可以添加自定义查询方法
    
    /**
     * 根据名称搜索药品
     * @param name 药品名称
     * @return 匹配的药品列表
     */
    @Select("SELECT * FROM medicine WHERE generic_name LIKE CONCAT('%', #{name}, '%')")
    List<Medicine> selectByName(String name);
}