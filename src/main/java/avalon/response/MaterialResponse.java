package avalon.response;

import avalon.model.items.MaterialModel;

public class MaterialResponse {

    public MaterialModel mat;

    public MaterialResponse(MaterialModel mat) {
        this.mat = mat;
    }

    public MaterialModel getMat() {
        return mat;
    }
    public void setMat(MaterialModel mat) {
        this.mat = mat;
    }
}
