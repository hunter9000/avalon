package com.test.model.dungeons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.model.CharModel;

import javax.persistence.*;
import java.util.List;

// container for a single map. linked to cells
@Entity
@Table(name="map")
@JsonIgnoreProperties(value = {"charModel"})
public class MapModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="char_id")      // owner
    private CharModel charModel;

    @Column(name="boss_level")
    private boolean isBoss;

//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="map_edge",
//            joinColumns={@JoinColumn(name="enter_map_id", referencedColumnName="id")},
//            inverseJoinColumns={@JoinColumn(name="exit_map_id", referencedColumnName="id")})
//    private List<MapModel> linkedMaps;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL)
    private List<CellModel> cells;

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

    public boolean isBoss() {
        return isBoss;
    }

    public void setIsBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }

//    public List<MapModel> getLinkedMaps() {
//        return linkedMaps;
//    }
//
//    public void setLinkedMaps(List<MapModel> linkedMaps) {
//        this.linkedMaps = linkedMaps;
//    }

    public List<CellModel> getCells() {
        return cells;
    }

    public void setCells(List<CellModel> cells) {
        this.cells = cells;
    }
}
