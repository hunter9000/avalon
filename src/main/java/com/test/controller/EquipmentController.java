package com.test.controller;

import com.test.model.EffectType;
import com.test.model.EquipmentModel;
import com.test.model.EquipmentSlot;
import com.test.model.ItemModel;
import io.jsonwebtoken.lang.Collections;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController {

    @RequestMapping(value="/api/equip", method=RequestMethod.GET)
    public List<EquipmentModel> getEquipment() {
        // get all the equipment rows this char has
        return null;
    }

    @RequestMapping(value="/api/equip", method=RequestMethod.POST)
    public void equipItem(ItemModel item, EquipmentSlot slot) {
        // validate the item belongs to char
        // check that item slot matches slot
        // if equipped in another slot, remove from there (switching hands?)
        // add equipment row
    }

    @RequestMapping(value="/api/equipmentSlots", method=RequestMethod.GET)
    public List<EquipmentSlot> getEquipmentSlots() {
        return Collections.arrayToList(EquipmentSlot.values());
    }
}
