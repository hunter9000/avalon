package avalon.controller;

import avalon.interceptor.CharacterSheetOwnerRequired;
import avalon.model.character.Character;
import avalon.request.EquipmentRequest;
import avalon.util.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EquipmentController {

    @Autowired
    private HttpServletRequest request;

//    @RequestMapping(value="/api/equip", method=RequestMethod.GET)
//    public List<Equipment> getEquipment() {
//        // get all the equipment rows this char has
//        return null;
//    }

    @RequestMapping(value="/api/char/{charId}/equipment/", method=RequestMethod.POST)
    @CharacterSheetOwnerRequired
    public void equipItem(@RequestBody EquipmentRequest equipmentRequest) {
        Character character = AuthUtils.getCharacter(request);



        // validate the item belongs to char
        // check that item slot matches slot
        // if equipped in another slot, remove from there (switching hands?)
        // add equipment row
    }

//    @RequestMapping(value="/api/equipmentSlots", method=RequestMethod.GET)
//    public List<EquipmentSlot> getEquipmentSlots() {
//        return Collections.arrayToList(EquipmentSlot.values());
//    }
}
