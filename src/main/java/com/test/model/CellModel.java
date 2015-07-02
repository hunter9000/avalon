package com.test.model;

import javax.persistence.Transient;

// has fk to the map it's in
class CellModel {
    private long id;
    private long mapId;
    private int x, y;
    private int groundType;

    @Transient
    private CellEntityModel cellEntity; // set when building the map by "placing" each entity on it's cell
}