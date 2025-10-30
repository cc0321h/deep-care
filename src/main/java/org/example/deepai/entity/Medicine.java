package org.example.deepai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Medicine {
    @TableId(type = IdType.AUTO)
    private int medicine_id;
    private String generic_name;
    private String indication;
    private String contraindication;
    private String dosage;
    private String interaction;
    public int getMedicine_id() {
        return medicine_id;
    }
    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }
    public String getGeneric_name() {
        return generic_name;
    }
    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }
    public String getIndication() {
        return indication;
    }
    public void setIndication(String indication) {
        this.indication = indication;
    }
    public String getContraindication() {
        return contraindication;
    }
    public void setContraindication(String contraindication) {
        this.contraindication = contraindication;
    }
    public String getDosage() {
        return dosage;
    }
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    public String getInteraction() {
        return interaction;
    }
    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    
}
