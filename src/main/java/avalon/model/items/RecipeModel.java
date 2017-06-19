package avalon.model.items;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="recipe")
public class RecipeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name="extra_capacity")
    private int extraCapacity;

    @OneToMany(mappedBy = "recipe")
    // the required mats and quantities
    private List<RecipeRequirementModel> recipeReqs;

    // the resulting object
    @OneToOne
    @JoinColumn(name="item_id")
    private ItemModel item;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<RecipeRequirementModel> getRecipeReqs() {
        return recipeReqs;
    }
    public void setRecipeReqs(List<RecipeRequirementModel> recipeReqs) {
        this.recipeReqs = recipeReqs;
    }

    public int getExtraCapacity() {
        return extraCapacity;
    }
    public void setExtraCapacity(int extraCapacity) {
        this.extraCapacity = extraCapacity;
    }

    public ItemModel getItem() {
        return item;
    }
    public void setItem(ItemModel item) {
        this.item = item;
    }
}
