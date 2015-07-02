package com.test.controller;

import com.sun.net.httpserver.Authenticator;
import com.test.model.MaterialEffectModel;
import com.test.model.MaterialModel;
import com.test.repository.MaterialRepository;
import com.test.response.MaterialResponse;
import com.test.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialsController     {

    @Autowired
    private MaterialRepository materialRepository;

    @RequestMapping(value = "/api/materials", method = RequestMethod.GET)
    public List<MaterialModel>  material() {
        List<MaterialModel> mats = materialRepository.findAll();

        return mats;
    }

    @RequestMapping(value="/api/materials", method=RequestMethod.POST)
    public SuccessResponse createMaterial(@RequestBody MaterialModel mat) {
        MaterialModel savedMat = materialRepository.save(mat);

        return new SuccessResponse(true, "Material created");
    }

    @RequestMapping(value="/api/materials/{matId}", method=RequestMethod.DELETE)
    public SuccessResponse deleteMaterial(@PathVariable long matId) {
        System.out.println("deleteing mat " + matId);
        materialRepository.delete(matId);
        return new SuccessResponse(true, "Material deleted");
    }

    @RequestMapping(value="/api/materials/{matId}/effect", method=RequestMethod.POST)
    public SuccessResponse createEffect(@PathVariable long matId, @RequestBody MaterialEffectModel effect) {
        MaterialModel mat = materialRepository.findById(matId);
        mat.getEffectList().add(effect);

        materialRepository.save(mat);

        return new SuccessResponse(true, "Effect added");
    }


}
