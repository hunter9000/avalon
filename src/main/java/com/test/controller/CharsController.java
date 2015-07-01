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
}
