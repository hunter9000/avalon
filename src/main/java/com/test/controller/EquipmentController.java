package com.test.controller;

public class EquipmentController {
    @RestController(name="/api/equip, GET")
    public List<Equipment> getEquipment() {
        // get all the equipment rows this char has
    }
    @RestController(name="/api/equip", POST)
    public void equip(item, slot) {
        // validate the item belongs to char
        // check that item slot matches slot
        // if equipped in another slot, remove from there (switching hands?)
        // add equipment row
    }

}
