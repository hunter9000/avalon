package com.test.controller;

import com.test.model.CharModel;
import com.test.model.User;
import com.test.repository.CharRepository;
import com.test.repository.UserRepository;
import com.test.response.SuccessResponse;
import com.test.security.JwtSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CharsController {

    @Autowired
    private CharRepository charRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    // get all chars
    @RequestMapping(value="/api/user/{userId}/chars", method=RequestMethod.GET)
    public List<CharModel> getChars(@PathVariable long userId) {
        List<CharModel> r = charRepository.findByUserId(userId);
        return r;
    }

    @RequestMapping(value="/api/chars", method=RequestMethod.POST)
    public SuccessResponse createChar(@RequestBody CharModel character) {
//        long userId = 1;        // todo get the jwt token here
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");

        User user = userRepository.findOne(token.getUserId());
        character.setUser(user);
        charRepository.save(character);
        return new SuccessResponse(true, "created character");
    }

    @RequestMapping(value="/api/char/", method=RequestMethod.GET)
    // get the char w/ equipment, inv, etc. add charId to jwt for reuse throughout angular app
    public CharModel getChar() {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
        long charId = token.getCharId();

        CharModel charModel = charRepository.findById(charId);
        return charModel;
    }

//    @RequestMapping(value="/api/chars/", method=RequestMethod.GET)
//    // get all chars belonging to user
//    public List<CharModel> getAllChars(@PathVariable long charId) {
//        return null;
//    }



    @RequestMapping(value="/api/chars/{charId}", method=RequestMethod.DELETE)
    // delete char
    public String deleteChar(@PathVariable long charId) {
        return "error";
    }
}
