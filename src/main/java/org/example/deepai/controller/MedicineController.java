package org.example.deepai.controller;

import org.example.deepai.entity.Medicine;
import org.example.deepai.result.Result;
import org.example.deepai.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 药品控制器
 * 处理药品相关的HTTP请求
 */
@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    /**
     * 获取所有药品
     * @return 药品列表
     */
    @GetMapping("/All")
    public Result<List<Medicine>> getAllMedicines() {
        try {
            List<Medicine> medicines = medicineService.getAllMedicines();
            return Result.success(medicines);
        } catch (Exception e) {
            return Result.error("获取药品列表失败：" + e.getMessage());
        }
    }

    /**
     * 根据名称搜索药品
     * @param name 药品名称
     * @return 匹配的药品列表
     */
    @GetMapping
    public Result<List<Medicine>> searchMedicinesByName(@RequestParam("name") String name) {
        try {
            List<Medicine> medicines = medicineService.searchMedicinesByName(name);
            return Result.success(medicines);
        } catch (Exception e) {
            return Result.error("搜索药品失败：" + e.getMessage());
        }
    }

    /**
     * 添加新药品
     * @param medicine 药品信息
     * @return 操作结果
     */
    @PostMapping
    public Result<String> addMedicine(@RequestBody Medicine medicine) {
        try {
            medicineService.addMedicine(medicine);
            return Result.success("添加药品成功");
        } catch (Exception e) {
            return Result.error("添加药品失败：" + e.getMessage());
        }
    }

    /**
     * 更新药品信息
     * @param medicine 药品信息
     * @return 操作结果
     */
    @PutMapping
    public Result updateMedicine(@RequestBody Medicine medicine) {
        try {
            medicineService.updateMedicine(medicine);
            return Result.success();
        } catch (Exception e) {
            return Result.error("更新药品失败：" + e.getMessage());
        }
    }

    /**
     * 删除药品
     * @param medicineId 药品ID
     * @return 操作结果
     */
    @DeleteMapping("/delete/{medicine_id}")
    public Result<String> deleteMedicine(@PathVariable("medicine_id") Integer medicine_id) {
        try {
            medicineService.deleteMedicine(medicine_id);
            return Result.success("删除药品成功");
        } catch (Exception e) {
            return Result.error("删除药品失败：" + e.getMessage());
        }
    }
}