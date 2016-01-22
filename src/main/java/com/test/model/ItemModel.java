package com.test.model;

import javax.persistence.*;

// the base definition of a craftable item. can be equipment, consumable
@Entity
@Table(name="item")
public class ItemModel {

    //        id, name,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="body_slot")
    private EquipmentSlot bodySlot;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public EquipmentSlot getBodySlot() {
        return bodySlot;
    }
    public void setBodySlot(EquipmentSlot bodySlot) {
        this.bodySlot = bodySlot;
    }
}
