package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "charModel")
    private List<MapModel> maps;

    @OneToOne
    @JoinColumn(name="curr_map_id")     // current map this char is in, or null
    private MapModel currentMap;

    @Column(name = "map_x")
    private Integer mapX;

    @Column(name = "map_y")
    private Integer mapY;

    @OneToMany(mappedBy = "charModel")
    private List<InventoryMaterialModel> inventoryMaterialModels;

    @OneToMany(mappedBy = "charModel")
    private List<EquipmentModel> inventoryEquipment;

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

    public MapModel getCurrentMap() {
        return currentMap;
    }
    public void setCurrentMap(MapModel currentMap) {
        this.currentMap = currentMap;
    }

    public List<MapModel> getMaps() {
        return maps;
    }
    public void setMaps(List<MapModel> maps) {
        this.maps = maps;
    }

    public Integer getMapX() {
        return mapX;
    }
    public void setMapX(Integer mapX) {
        this.mapX = mapX;
    }

    public Integer getMapY() {
        return mapY;
    }
    public void setMapY(Integer mapY) {
        this.mapY = mapY;
    }

    public List<InventoryMaterialModel> getInventoryMaterialModels() {
        return inventoryMaterialModels;
    }
    public void setInventoryMaterialModels(List<InventoryMaterialModel> inventoryMaterialModels) {
        this.inventoryMaterialModels = inventoryMaterialModels;
    }

    public List<EquipmentModel> getInventoryEquipment() {
        return inventoryEquipment;
    }
    public void setInventoryEquipment(List<EquipmentModel> inventoryEquipment) {
        this.inventoryEquipment = inventoryEquipment;
    }
}
