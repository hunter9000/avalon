package com.test.request;

import com.test.model.items.InventoryMaterialModel;

import java.util.List;

/** Encapsulates the request to craft an item. the id is the recipe's id, extraMats are all the extra materials to be added. */
public class RecipeCraftRequest {

    private long id;
    private List<InventoryMaterialModel> extraMats;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public List<InventoryMaterialModel> getExtraMats() {
        return extraMats;
    }
    public void setExtraMats(List<InventoryMaterialModel> extraMats) {
        this.extraMats = extraMats;
    }
}
