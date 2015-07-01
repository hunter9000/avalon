package com.test.controller;


public class MapsController {

    @RestController(name="/api/map/{mapId}", GET)
    // if this map exists, return it, otherwise build and return
    // query all cells, and all entities
    // build transient helper lists by putting all enemies, nodes, etc in lists
    // tell each cell what entity is on it
    @RestController(name="/api/map/leave", POST)
    // delete the map, reset player back home
    // check if standing on the door
    @RestController(name="/api/map/moveto", POST)
    // move player
    @RestController(name="/api/map/attack", POST)
    // attack the given cell with given attack
    @RestController(name="/api/map/useItem", POST)
    // use selected consumable
    @RestController(name="/api/map/endturn", POST)
    // end turn, figure out what all enemeies will do, send back their actions to be replayed by client
}
