package avalon.model.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import avalon.model.CharModel;

import javax.persistence.*;

@Entity
@Table(name="inventory_material")
@JsonIgnoreProperties(value = "charModel")
public class InventoryMaterialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name="char_id")
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
