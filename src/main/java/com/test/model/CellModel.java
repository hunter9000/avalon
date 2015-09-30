package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

// has fk to the map it's in
@Entity
@Table(name="cell")
@JsonIgnoreProperties(value="map")
public class CellModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="map_id")
    private MapModel map;

    @Column(name="cell_x")
    private int x;

    @Column(name="cell_y")
    private int y;

    @Enumerated(EnumType.STRING)
    private GroundType groundType;

    @Transient
    private CellEntityModel cellEntity; // set when building the map by "placing" each entity on it's cell

    public CellModel() {

    }

    public CellModel(MapModel map, int x, int y, GroundType groundType) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.groundType = groundType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MapModel getMap() {
        return map;
    }

    public void setMap(MapModel map) {
        this.map = map;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GroundType getGroundType() {
        return groundType;
    }

    public void setGroundType(GroundType groundType) {
        this.groundType = groundType;
    }
}