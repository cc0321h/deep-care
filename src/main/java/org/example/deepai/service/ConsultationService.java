package org.example.deepai.service;

import java.util.List;

import org.example.deepai.entity.Consultation;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface ConsultationService {
    /**
     * 获取所有咨询记录
     * @return 所有咨询记录列表
     */
    Page<Consultation> getAllConsultations(int pageNum, int pageSize);

    /**
     * 获取所有咨询记录
     * @return 所有咨询记录列表
     */
    List<Consultation> getAllConsultations();

    /**
     * 根据名称获取咨询记录
     * @param name 咨询记录名称
     * @return 咨询记录
     */
    List<Consultation> getConsultationByName(String name);

    /**
     * 根据ID获取咨询记录
     * @param consultationId 咨询记录ID
     * @return 咨询记录
     */
    List<Consultation> getConsultationById(int consultationId);
    
    /**
     * 添加问诊记录
     * @param consultation 问诊记录对象
     * @return 是否添加成功
     */
    boolean addConsultation(Consultation consultation);

    void updataConsultation(Consultation consultation);

    void deleteConsultation(int consultationId);
    
}
