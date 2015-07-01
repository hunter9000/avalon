package com.test.controller;

import com.test.model.MaterialModel;
import com.test.repository.MaterialRepository;
import com.test.response.MaterialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialsController     {

    @Autowired
    private MaterialRepository materialRepository;


    @RequestMapping(value = "/api/materials", method = RequestMethod.GET)
    public List<MaterialModel>  material() {
        List<MaterialModel> mats = materialRepository.findAll();

        return mats;

//        return "hello";
    }

//    @RequestMapping(value="/api/materials", method = RequestMethod.GET)
//    public MaterialResponse material() {
//
//        MaterialModel mat =  materialRepository.findById(1);
//        MaterialResponse response = new MaterialResponse();
//        response.mat = mat;
//        return response;
//    }

//    @RequestMapping(value="/api/materials", method = RequestMethod.GET)
//    public String material() {
//
//
//        return "poop lol";
//    }

}