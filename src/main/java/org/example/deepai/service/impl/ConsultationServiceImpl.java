package org.example.deepai.service.impl;

import java.util.List;

import org.example.deepai.entity.Consultation;
import org.example.deepai.mapper.ConsultationMapper;
import org.example.deepai.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class ConsultationServiceImpl implements ConsultationService{
    @Autowired
    private ConsultationMapper consultationMapper;
    
    @Override
    public Page<Consultation> getAllConsultations(int pageNum, int pageSize) {
        // return consultationMapper.selectList(null);
        return consultationMapper.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationMapper.selectList(null);
    }

    @Override
    public List<Consultation> getConsultationByName(String name) {
        return consultationMapper.selectList(
            new QueryWrapper<Consultation>().eq("name", name)
        );
    }

    @Override
    public List<Consultation> getConsultationById(int consultationId) {
        return consultationMapper.selectList(
            new QueryWrapper<Consultation>().eq("consultationId", consultationId)
        );
    }
    
    @Override
    public boolean addConsultation(Consultation consultation) {
        // 设置创建时间
        if (consultation.getCreateTime() == null || consultation.getCreateTime().isEmpty()) {
            consultation.setCreateTime(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        // 插入数据库
        return consultationMapper.insert(consultation) > 0;
    }

    @Override
    public void updataConsultation(Consultation consultation) {
        int res = consultationMapper.updateById(consultation);
        if (res == 1) {
            System.out.println("修改成功");   
        }
    }

    @Override
    public void deleteConsultation(int consultationId) {
        int res = consultationMapper.deleteById(consultationId);
         if (res == 1) {
            System.out.println("删除成功");   
        }
    }
}
