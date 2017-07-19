package avalon.model.items.equipment;

import avalon.model.character.Character;
import avalon.model.items.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="equipment_item")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;        // the base item definition

    @OneToOne
    @JoinColumn(name = "char_id")
    @JsonIgnore
    private Character character;        // char this belongs to

    @OneToMany(mappedBy = "equipment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name="item_effect",
//            joinColumns={@JoinColumn(name="item_id", referencedColumnName="id")},
//            inverseJoinColumns={@JoinColumn(name="item_effect_id", referencedColumnName="id")})
    private List<ItemEffect> itemEffects;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public Character getCharacter() {
        return character;
    }
    public void setCharacter(Character character) {
        this.character = character;
    }

    public List<ItemEffect> getItemEffects() {
        return itemEffects;
    }
    public void setItemEffects(List<ItemEffect> itemEffects) {
        this.itemEffects = itemEffects;
    }

//    private long charId;
//    private long itemId;
//    private EquipmentSlot slot;

}
