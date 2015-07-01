package com.test.model;

import javax.persistence.*;

@Entity
@Table(name = "material_effect")
public class MaterialEffectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne      // many mateffects reference one material
    @JoinColumn(name="material_id")     // material_id is the fk column pointing to material table
    private MaterialModel materialModel;

    @Column(name = "type")
    private EffectType effectType;

    @Column(name = "val")
    private int value;

    @Column(name = "slot")
    private EquipmentSlot slot;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public MaterialModel getMaterialModel() {
        return materialModel;
    }
    public void setMaterialModel(MaterialModel materialModel) {
        this.materialModel = materialModel;
    }

    public EffectType getEffectType() {
        return effectType;
    }
    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public EquipmentSlot getSlot() {
        return slot;
    }
    public void setSlot(EquipmentSlot slot) {
        this.slot = slot;
    }
}
