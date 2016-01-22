package com.test.model;

import javax.persistence.*;

// join table linking effects to an item
@Entity
@Table(name="item_effect")
public class ItemEffectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "equipment_id")
    private EquipmentModel equipmentModel;

    @Column(name = "material_effect_id")
    private MaterialEffectModel materialEffect;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }
    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public MaterialEffectModel getMaterialEffect() {
        return materialEffect;
    }
    public void setMaterialEffect(MaterialEffectModel materialEffect) {
        this.materialEffect = materialEffect;
    }

    //    private long effectId;
//    private int value;

}
