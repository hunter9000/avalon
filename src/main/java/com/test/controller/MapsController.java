package com.test.controller;


import com.test.model.MapModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MapsController {

    @RequestMapping(value="/api/map/{mapId}", method=RequestMethod.GET)
    // if this map exists, return it, otherwise build and return
    // query all cells, and all entities
    // build transient helper lists by putting all enemies, nodes, etc in lists
    // tell each cell what entity is on it
    public MapModel getMap(long id) {
        return null;
    }

    @RequestMapping(value="/api/map/leave", method=RequestMethod.POST)
    // delete the map, reset player back home
    // check if standing on the door
    public String leaveMap(long id) {
        return "success";
    }

    @RequestMapping(value="/api/map/moveto", method=RequestMethod.POST)
    // move player
    public String moveOnMap() {
        return "success";
    }

    @RequestMapping(value="/api/map/attack", method=RequestMethod.POST)
    // attack the given cell with given attack
    public void attack() {

    }

    @RequestMapping(value="/api/map/useItem", method=RequestMethod.POST)
    // use selected consumable
    public void useItem() {

    }

    @RequestMapping(value="/api/map/endturn", method=RequestMethod.POST)
    // end turn, figure out what all enemeies will do, send back their actions to be replayed by client
    public void endTurn() {

    }


//    enterDng() {
//        // all maps should already be cleared, check again?
//        // create graph of maps, with edges.
//        // pick random v as head map
//        // for each vertex in g,
//        // create new Map(v)
//        // for each edge in g,
//        // create new MapEdge(e.1, e.2)
//        // store those objects
//
//        // enter head map
//    }
//    enterMap(map) {
//        // query all cells
//        // if empty,
//        // create cells
//        // create random entities
//        // create portals based on map.mapEdges
//        // store those objects
//        // requery all cells
//        // place char randomly
//    }

}
