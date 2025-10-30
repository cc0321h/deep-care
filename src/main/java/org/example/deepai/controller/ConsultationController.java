package org.example.deepai.controller;

import java.util.List;

import org.example.deepai.entity.Consultation;
import org.example.deepai.result.Result;
import org.example.deepai.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/All/{pageNum}/{pageSize}")
    public Result<Page<Consultation>> getAllConsultations(int pageNum, int pageSize) {
        return Result.success(consultationService.getAllConsultations(pageNum, pageSize));
    }

    @GetMapping("/All")
    public Result<List<Consultation>> getAllConsultations() {
        return Result.success(consultationService.getAllConsultations());
    }
    
    @GetMapping
    public Result<List<Consultation>> getConsultationByName(@RequestParam("name") String name) {
        return Result.success(consultationService.getConsultationByName(name));
    }

    @GetMapping("/{consultationId}")
    public Result<List<Consultation>> getConsultationById(@PathVariable int consultationId) {
        return Result.success(consultationService.getConsultationById(consultationId));
    }
    
    
    /**
     * 添加问诊记录
     * @param consultation 问诊记录对象
     * @return 添加结果
     */
    @PostMapping
    public Result addConsultation(@RequestBody Consultation consultation) {
        boolean success = consultationService.addConsultation(consultation);
        if (success) {
            return Result.success();
        } else {
            return Result.error("添加失败");
        }
    }

    @PutMapping
    public Result updataConsultation(@RequestBody Consultation consultation){
        consultationService.updataConsultation(consultation);
        return Result.success();
    }
    
    @DeleteMapping("/delete/{consultationId}")
    public Result deleteConsultation(@PathVariable int consultationId){
        consultationService.deleteConsultation(consultationId);
        return Result.success();
    }
    
}
