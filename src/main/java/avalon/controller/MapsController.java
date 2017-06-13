package avalon.controller;


import avalon.interceptor.CharacterSheetOwnerRequired;
import avalon.model.dungeons.CellModel;
import avalon.repository.CellRepository;
import avalon.repository.CharRepository;
import avalon.repository.MapRepository;
import avalon.security.JwtSubject;
import avalon.model.CharModel;
import avalon.model.dungeons.GroundType;
import avalon.model.dungeons.MapModel;
import avalon.response.SuccessResponse;
import avalon.util.AuthUtils;
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


     /** if this map exists, return it or return null. Use the portal method to enter a map if null. */
//    @RequestMapping(value="/api/char/{charId}/map/", method=RequestMethod.GET)
//    public MapModel getMap(@PathVariable long charId) {
//        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
////        long charId = token.getCharId();
//        CharModel charModel = charRepository.findById(charId);
//        if (charModel.getCurrentMap() != null) {
//            return charModel.getCurrentMap();
//        }
//
//        return null;
//    }

    /** Enter the portal given. If user is not in a map already, create the appropriate map and return it, saving that the char is in it.
     *  query all cells, and all entities
     *  build transient helper lists by putting all enemies, nodes, etc in lists
     *  tell each cell what entity is on it */
    @RequestMapping(value="/api/char/{charId}/portal/{portalId}/", method=RequestMethod.POST)
    @CharacterSheetOwnerRequired
    public MapModel enterPortal(@PathVariable long charId, @PathVariable long portalId) {
//        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
        CharModel charModel = (CharModel)request.getAttribute(AuthUtils.CHARACTER_NAME);
//        long charId = token.getCharId();
        // make sure the char is not in a map already
//        CharModel charModel = charRepository.findById(charId);
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
    @RequestMapping(value="/api/char/{charId}/map/leave", method=RequestMethod.POST)
    public SuccessResponse leaveMap(@PathVariable long charId) {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
//        long charId = token.getCharId();

        CharModel charModel = charRepository.findById(charId);
        charModel.setCurrentMap(null);

        charRepository.save(charModel);

        return new SuccessResponse(true, "success");
    }

    @RequestMapping(value="/api/char/{charId}/map/moveto/x/{x}/y/{y}", method=RequestMethod.POST)
    // move player
    public SuccessResponse moveOnMap(@PathVariable long charId, @PathVariable int x, @PathVariable int y) {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
//        long charId = token.getCharId();
        // make sure the char is not in a map already
        CharModel charModel = charRepository.findById(charId);
        if (charModel.getCurrentMap() != null) {
            // check if char can move
            return new SuccessResponse(true, "success");
        }

        return new SuccessResponse(false, "error");
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
