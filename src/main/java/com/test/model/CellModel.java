package com.test.model;

// has fk to the map it's in
class CellModel {
    private long id;
    private long mapId;
    private int x, y;
    private groundtype;
    @Transient CellEntity; // set when building the map by "placing" each entity on it's cell
}