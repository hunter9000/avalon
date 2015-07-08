package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "characters")
@JsonIgnoreProperties(value="user")
public class CharModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne      // many chars reference one user
    @JoinColumn(name="user_id")     // user_id is the fk column pointing to user table
    private User user;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="character_recipe",
            joinColumns={@JoinColumn(name="char_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="recipe_id", referencedColumnName="id")})
    private List<RecipeModel> recipes;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeModel> getRecipes() {
        return recipes;
    }
    public void setRecipes(List<RecipeModel> recipes) {
        this.recipes = recipes;
    }
}
