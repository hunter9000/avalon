package com.test.model;

import javax.persistence.*;

// links a material to a recipe as a required mat, and gives the quant
@Entity
@Table(name="recipe_requirement")
public class RecipeRequirementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne      // many mateffects reference one material
    @JoinColumn(name="recipe_id")     // material_id is the fk column pointing to material table
    private RecipeModel recipe;

//    @OneToOne
//    @JoinColumn(name="material_id", )
//    private MaterialModel mat;

    @Column(name="quantity")
    private int quantity;


    public RecipeModel getRecipe() {
        return recipe;
    }
    public void setRecipe(RecipeModel recipe) {
        this.recipe = recipe;
    }

//    public MaterialModel getMat() {
//        return mat;
//    }
//    public void setMat(MaterialModel mat) {
//        this.mat = mat;
//    }

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
