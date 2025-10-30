package org.example.deepai.service.impl;

import org.example.deepai.entity.Medicine;
import org.example.deepai.mapper.MedicineMapper;
import org.example.deepai.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品服务实现类
 * 实现药品相关的业务逻辑
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public List<Medicine> getAllMedicines() {
        // 使用MyBatis-Plus的selectList方法，传入null表示查询所有
        return medicineMapper.selectList(null);
    }

    @Override
    public List<Medicine> searchMedicinesByName(String name) {
        return medicineMapper.selectByName(name);
    }

    @Override
    public void addMedicine(Medicine medicine) {
        // 验证必填字段
        if (medicine.getGeneric_name() == null || medicine.getGeneric_name().trim().isEmpty()) {
            throw new IllegalArgumentException("药品通用名不能为空");
        }
        // 使用MyBatis-Plus的insert方法
        medicineMapper.insert(medicine);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        // 验证药品是否存在
        Medicine existingMedicine = medicineMapper.selectById(medicine.getMedicine_id());
        if (existingMedicine == null) {
            throw new IllegalArgumentException("药品不存在");
        }
        // 使用MyBatis-Plus的updateById方法
        medicineMapper.updateById(medicine);
    }

    @Override
    public void deleteMedicine(Integer medicineId) {
        // 验证药品是否存在
        Medicine existingMedicine = medicineMapper.selectById(medicineId);
        if (existingMedicine == null) {
            throw new IllegalArgumentException("药品不存在");
        }
        // 使用MyBatis-Plus的deleteById方法
        medicineMapper.deleteById(medicineId);
    }
}