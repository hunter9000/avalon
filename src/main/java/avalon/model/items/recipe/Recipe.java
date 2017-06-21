package avalon.model.items.recipe;

import avalon.model.items.Item;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name="extra_capacity")
    private int extraCapacity;

    @OneToMany(mappedBy = "recipe")
    // the required mats and quantities
    private List<RecipeRequirement> recipeReqs;

    // the resulting object
    @OneToOne
    @JoinColumn(name="item_id")
    private Item item;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<RecipeRequirement> getRecipeReqs() {
        return recipeReqs;
    }
    public void setRecipeReqs(List<RecipeRequirement> recipeReqs) {
        this.recipeReqs = recipeReqs;
    }

    public int getExtraCapacity() {
        return extraCapacity;
    }
    public void setExtraCapacity(int extraCapacity) {
        this.extraCapacity = extraCapacity;
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
