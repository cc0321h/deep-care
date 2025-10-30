package org.example.deepai.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.deepai.entity.Consultation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface ConsultationMapper extends BaseMapper<Consultation>{
    
}
