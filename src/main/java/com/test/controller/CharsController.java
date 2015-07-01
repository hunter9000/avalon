package com.test.controller;

import com.test.request.CharsRequest;
import com.test.response.CharsResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharsController {

    @RequestMapping(value="/api/chars", method= RequestMethod.GET)
    public CharsResponse chars( @RequestBody CharsRequest request) {

        return null;
    }

    @RestController(name="/api/chars/{userId}", GET)
    // get all chars belonging to user
    @RestController(name="/api/chars/{charId}", GET)
    // get the char w/ equipment, inv, etc. add charId to jwt for reuse throughout angular app
    @RestController(name="/api/chars", POST)
    // create new char
    @RestController(name="/api/chars/{charId}", DELETE)
    // delete char
}
