package org.example.deepai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Consultation {
    @TableId(type = IdType.AUTO)
    private int consultationId;
    
    private int userId;
    private String name;
    private String status;
    private String symptomDescription;
    private String aiDiagnosis;
    private String doctorOpinion;
    private String createTime;
    public int getConsultationId() {
        return consultationId;
    }
    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSymptomDescription() {
        return symptomDescription;
    }
    public void setSymptomDescription(String symptomDescription) {
        this.symptomDescription = symptomDescription;
    }
    public String getAiDiagnosis() {
        return aiDiagnosis;
    }
    public void setAiDiagnosis(String aiDiagnosis) {
        this.aiDiagnosis = aiDiagnosis;
    }
    public String getDoctorOpinion() {
        return doctorOpinion;
    }
    public void setDoctorOpinion(String doctorOpinion) {
        this.doctorOpinion = doctorOpinion;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
