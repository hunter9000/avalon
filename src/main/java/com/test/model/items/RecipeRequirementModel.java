package com.test.model.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

// links a material to a recipe as a required mat, and gives the quant
@Entity
@Table(name="recipe_requirement")
@JsonIgnoreProperties(value = "recipe")
public class RecipeRequirementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne      // many mateffects reference one material
    @JoinColumn(name="recipe_id")     // material_id is the fk column pointing to material table
    private RecipeModel recipe;

    @OneToOne
    @JoinColumn(name="material_id")
    private MaterialModel materialModel;

    @Column(name="quantity")
    private int quantity;


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
