package avalon.model.items;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

// links a material to a recipe as a required mat, and gives the quant
@Entity
@Table(name="recipe_requirement")
public class RecipeRequirementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne      // many mateffects reference one material
    @JoinColumn(name="recipe_id")     // material_id is the fk column pointing to material table
    @JsonIgnore
    private RecipeModel recipe;

    @OneToOne
    @JoinColumn(name="material_id")
    private MaterialModel materialModel;

    @Column(name="quantity")
    private int quantity;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public RecipeModel getRecipe() {
        return recipe;
    }
    public void setRecipe(RecipeModel recipe) {
        this.recipe = recipe;
    }

    public MaterialModel getMaterialModel() {
        return materialModel;
    }
    public void setMaterialModel(MaterialModel mat) {
        this.materialModel = mat;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
