package avalon.model.items;

import javax.persistence.*;

// join table linking effects to an item
@Entity
@Table(name="item_effect")
public class ItemEffectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "equipment_id")
    private EquipmentModel equipmentModel;

    @OneToOne()
    @JoinColumn(name = "material_effect_id")
    private MaterialEffectModel materialEffect;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
