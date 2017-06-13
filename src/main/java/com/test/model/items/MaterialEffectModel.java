package com.test.model.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "material_effect")
@JsonIgnoreProperties(value = { "materialModel" })
public class MaterialEffectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne      // many mateffects reference one material
    @JoinColumn(name="material_id")     // material_id is the fk column pointing to material table
    private MaterialModel materialModel;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private EffectType effectType;

    @Column(name = "val")
    private int value;

    @Column(name = "slot")
    @Enumerated(value = EnumType.STRING)
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
