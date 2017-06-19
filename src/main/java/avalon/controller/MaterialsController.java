package avalon.controller;

import avalon.model.items.MaterialEffectModel;
import avalon.model.items.EffectType;
import avalon.model.items.MaterialModel;
import avalon.repository.MaterialEffectRepository;
import avalon.repository.MaterialRepository;
import avalon.response.SuccessResponse;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialsController {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MaterialEffectRepository materialEffectRepository;

    @RequestMapping(value = "/api/materials/", method = RequestMethod.GET)
    public List<MaterialModel>  material() {
        List<MaterialModel> mats = materialRepository.findAll();

        return mats;
    }

    @RequestMapping(value="/api/materials/", method=RequestMethod.POST)
    public SuccessResponse createMaterial(@RequestBody MaterialModel mat) {
        for (MaterialEffectModel effect : mat.getEffectList()) {
            effect.setMaterialModel(mat);
        }
        MaterialModel savedMat = materialRepository.save(mat);

        return new SuccessResponse(true, "Material created");
    }

    @RequestMapping(value="/api/materials/{matId}/", method=RequestMethod.DELETE)
    public SuccessResponse deleteMaterial(@PathVariable long matId) {
        System.out.println("deleteing mat " + matId);
        MaterialModel mat = materialRepository.findById(matId);
        for (MaterialEffectModel eff : mat.getEffectList()) {
            materialEffectRepository.delete(eff);
        }

        materialRepository.delete(matId);
        return new SuccessResponse(true, "Material deleted");
    }

    @RequestMapping(value="/api/materials/{matId}/effect/", method=RequestMethod.POST)
    public SuccessResponse createEffect(@PathVariable long matId, @RequestBody MaterialEffectModel effect) {
        MaterialModel mat = materialRepository.findById(matId);
//        mat.getEffectList().add(effect);

        effect.setMaterialModel(mat);

        materialEffectRepository.save(effect);

        MaterialModel newMat = materialRepository.save(mat);

        return new SuccessResponse(true, "Effect added");
    }

    @RequestMapping(value="/api/materials/{matId}/effect/{effId}", method=RequestMethod.DELETE)
    public SuccessResponse deleteEffect(@PathVariable long matId, @PathVariable long effId) {
        // TODO: check that the effect belongs to this mat

        materialEffectRepository.delete(effId);

        return new SuccessResponse(true, "Effect deleted");
    }


    @RequestMapping(value="/api/effectTypes", method=RequestMethod.GET)
    public List<EffectType> getEffectTypes() {
        return Collections.arrayToList(EffectType.values());
    }

}
