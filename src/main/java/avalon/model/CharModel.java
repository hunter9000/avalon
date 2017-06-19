package avalon.model;

import avalon.model.dungeons.MapModel;
import avalon.model.items.EquipmentModel;
import avalon.model.items.InventoryMaterialModel;
import avalon.model.items.RecipeModel;
import avalon.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characters")
@JsonIgnoreProperties(value="user")
public class CharModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne      // many chars reference one user
    @JoinColumn(name="user_id", nullable = false, updatable = false)     // user_id is the fk column pointing to user table
    private User user;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="character_recipe",
            joinColumns={@JoinColumn(name="char_id", referencedColumnName="id")},		// column that points to this table
            inverseJoinColumns={@JoinColumn(name="recipe_id", referencedColumnName="id")})		// column that points to other table
    private Set<RecipeModel> recipes;

    @OneToMany(mappedBy = "charModel", fetch = FetchType.EAGER)
    private Set<MapModel> maps;

    @OneToOne
    @JoinColumn(name="curr_map_id")     // current map this char is in, or null
    private MapModel currentMap;

    @Column(name = "map_x")
    private Integer mapX;

    @Column(name = "map_y")
    private Integer mapY;

    @OneToMany(mappedBy = "charModel", fetch = FetchType.EAGER)
    private Set<InventoryMaterialModel> inventoryMaterialModels;

    @OneToMany(mappedBy = "charModel", fetch = FetchType.EAGER)
    private Set<EquipmentModel> inventoryEquipment;

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

    public Set<RecipeModel> getRecipes() {
        return recipes;
    }
    public void setRecipes(Set<RecipeModel> recipes) {
        this.recipes = recipes;
    }

    public MapModel getCurrentMap() {
        return currentMap;
    }
    public void setCurrentMap(MapModel currentMap) {
        this.currentMap = currentMap;
    }

    public Set<MapModel> getMaps() {
        return maps;
    }
    public void setMaps(Set<MapModel> maps) {
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

    public Set<InventoryMaterialModel> getInventoryMaterialModels() {
        return inventoryMaterialModels;
    }
    public void setInventoryMaterialModels(Set<InventoryMaterialModel> inventoryMaterialModels) {
        this.inventoryMaterialModels = inventoryMaterialModels;
    }

    public Set<EquipmentModel> getInventoryEquipment() {
        return inventoryEquipment;
    }
    public void setInventoryEquipment(Set<EquipmentModel> inventoryEquipment) {
        this.inventoryEquipment = inventoryEquipment;
    }
}
