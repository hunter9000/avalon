package avalon.model.dungeons;

import avalon.model.CharModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

// container for a single map. linked to cells
@Entity
@Table(name="map")
public class MapModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="char_id")      // owner
    @JsonIgnore
    private CharModel charModel;

    @Column(name="boss_level")
    private boolean isBoss;

//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="map_edge",
//            joinColumns={@JoinColumn(name="enter_map_id", referencedColumnName="id")},
//            inverseJoinColumns={@JoinColumn(name="exit_map_id", referencedColumnName="id")})
//    private List<MapModel> linkedMaps;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CellModel> cells;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public CharModel getCharModel() {
        return charModel;
    }
    public void setCharModel(CharModel charModel) {
        this.charModel = charModel;
    }

    public boolean isBoss() {
        return isBoss;
    }
    public void setBoss(boolean boss) {
        isBoss = boss;
    }

    public List<CellModel> getCells() {
        return cells;
    }
    public void setCells(List<CellModel> cells) {
        this.cells = cells;
    }
}
