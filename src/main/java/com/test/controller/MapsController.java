package com.test.controller;


import com.test.model.CellModel;
import com.test.model.CharModel;
import com.test.model.GroundType;
import com.test.model.MapModel;
import com.test.repository.CellRepository;
import com.test.repository.CharRepository;
import com.test.repository.MapRepository;
import com.test.security.JwtSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MapsController {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private CharRepository charRepository;

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private HttpServletRequest request;


     /** if this map exists, return it, otherwise build and return
      * query all cells, and all entities
      * build transient helper lists by putting all enemies, nodes, etc in lists
      * tell each cell what entity is on it */
    @RequestMapping(value="/api/char/map/", method=RequestMethod.GET)
    public MapModel getMap() {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
        long charId = token.getCharId();
        CharModel charModel = charRepository.findById(charId);
        if (charModel.getCurrentMap() != null) {
            return charModel.getCurrentMap();
        }

        return null;
    }

    /** Enter the portal given. If user is not in a map already, create the appropriate map and return it, saving that the char is in it.
     */
    @RequestMapping(value="/api/portal/{portalId}", method=RequestMethod.POST)
    public MapModel enterPortal(@PathVariable long portalId) {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
        long charId = token.getCharId();
        // make sure the char is not in a map already
        CharModel charModel = charRepository.findById(charId);
        if (charModel.getCurrentMap() == null) {
            MapModel newMap = constructMapModelByPortalId(portalId, charId);
            mapRepository.save(newMap);
            for (CellModel cell : newMap.getCells()) {
                cellRepository.save(cell);
            }
            charModel.setCurrentMap(newMap);
            charRepository.save(charModel);
            return newMap;
        }

        return null;
    }

    // delete the map, reset player back home
    // check if standing on the door
    @RequestMapping(value="/api/map/leave", method=RequestMethod.POST)
    public String leaveMap() {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
        long charId = token.getCharId();

        CharModel charModel = charRepository.findById(charId);
        charModel.setCurrentMap(null);

        charRepository.save(charModel);

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

    private MapModel constructMapModelByPortalId(long portalId, long charId) {
        // figure out the type, difficulty, etc.
        MapModel mapModel = new MapModel();
        CharModel charModel = charRepository.findById(charId);
        mapModel.setCharModel(charModel);
        mapModel.setIsBoss(false);

        List<CellModel> cells = new ArrayList<>();
        for (int j=0; j<5; j++) {
            for (int i=0; i<5; i++) {
                cells.add(new CellModel(mapModel, i, j, GroundType.GRASS));
            }
        }
        mapModel.setCells(cells);
        return mapModel;
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
