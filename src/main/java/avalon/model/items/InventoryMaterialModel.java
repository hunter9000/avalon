package avalon.model.items;

import avalon.model.CharModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="inventory_material")
public class InventoryMaterialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name="char_id")
    @JsonIgnore
    private CharModel charModel;

    @ManyToOne
    @JoinColumn(name="material_id")
    private MaterialModel materialModel;

    @Column(name = "quantity")
    private int quantity;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public CharModel getCharModel() {
        return charModel;
    }
    public void setCharModel(CharModel charModel) {
        this.charModel = charModel;
    }

    public MaterialModel getMaterialModel() {
        return materialModel;
    }
    public void setMaterialModel(MaterialModel materialModel) {
        this.materialModel = materialModel;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
