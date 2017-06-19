package avalon.model.items;

import avalon.model.CharModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="equipment_item")
public class EquipmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private ItemModel itemModel;        // the base item definition

    @OneToOne
    @JoinColumn(name = "char_id")
    @JsonIgnore
    private CharModel charModel;        // char this belongs to

    @OneToMany(mappedBy = "equipmentModel")
//    @JoinTable(name="item_effect",
//            joinColumns={@JoinColumn(name="item_id", referencedColumnName="id")},
//            inverseJoinColumns={@JoinColumn(name="item_effect_id", referencedColumnName="id")})
    private List<ItemEffectModel> itemEffects;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }
    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public CharModel getCharModel() {
        return charModel;
    }
    public void setCharModel(CharModel charModel) {
        this.charModel = charModel;
    }

    public List<ItemEffectModel> getItemEffects() {
        return itemEffects;
    }
    public void setItemEffects(List<ItemEffectModel> itemEffects) {
        this.itemEffects = itemEffects;
    }

//    private long charId;
//    private long itemId;
//    private EquipmentSlot slot;

}
