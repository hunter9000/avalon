package com.test.controller;

import com.test.model.CharModel;
import com.test.request.CharsRequest;
import com.test.response.CharsResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharsController {

    @RequestMapping(value="/api/chars", method=RequestMethod.GET)
    public CharsResponse chars( @RequestBody CharsRequest request) {

        return null;
    }

    @RequestMapping(value="/api/chars/{userId}", method=RequestMethod.GET)
    // get all chars belonging to user
    public List<CharModel> getAllChars() {
        return null;
    }

    @RequestMapping(value="/api/chars/{charId}", method=RequestMethod.GET)
    // get the char w/ equipment, inv, etc. add charId to jwt for reuse throughout angular app
    public CharModel getChar() {
        return null;
    }

    @RequestMapping(value="/api/chars", method=RequestMethod.POST)
    // create new char
    public CharModel createChar() {
        return null;
    }

    @RequestMapping(value="/api/chars/{charId}", method=RequestMethod.DELETE)
    // delete char
    public String deleteChar() {
        return "success";
    }
}
