package org.example.deepai.service;

import org.example.deepai.entity.Medicine;

import java.util.List;

/**
 * 药品服务接口
 * 定义药品相关的业务逻辑方法
 */
public interface MedicineService {

    /**
     * 获取所有药品
     * @return 药品列表
     */
    List<Medicine> getAllMedicines();

    /**
     * 根据名称搜索药品
     * @param name 药品名称
     * @return 匹配的药品列表
     */
    List<Medicine> searchMedicinesByName(String name);

    /**
     * 添加新药品
     * @param medicine 药品信息
     */
    void addMedicine(Medicine medicine);

    /**
     * 更新药品信息
     * @param medicine 药品信息
     */
    void updateMedicine(Medicine medicine);

    /**
     * 删除药品
     * @param medicineId 药品ID
     */
    void deleteMedicine(Integer medicineId);
}