package avalon.request;

import avalon.model.items.InventoryMaterial;

import java.util.List;

/** Encapsulates the request to craft an item. the id is the recipe's id, extraMats are all the extra materials to be added. */
public class RecipeCraftRequest {

    private long id;
    private List<InventoryMaterial> extraMats;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public List<InventoryMaterial> getExtraMats() {
        return extraMats;
    }
    public void setExtraMats(List<InventoryMaterial> extraMats) {
        this.extraMats = extraMats;
    }
}
