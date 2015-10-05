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

    /** get all chars for the user */
    @RequestMapping(value="/api/user/{userId}/chars", method=RequestMethod.GET)
    public List<CharModel> getChars(@PathVariable long userId) {
        List<CharModel> r = charRepository.findByUserId(userId);
        return r;
    }

    /** Create a character */
    @RequestMapping(value="/api/chars", method=RequestMethod.POST)
    public SuccessResponse createChar(@RequestBody CharModel character) {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");

        User user = userRepository.findOne(token.getUserId());
        character.setUser(user);
        charRepository.save(character);
        return new SuccessResponse(true, "created character");
    }

    /** get the char w/ equipment, inv, etc. add charId to jwt for reuse throughout angular app */
    @RequestMapping(value="/api/char/", method=RequestMethod.GET)
    public CharModel getChar() {
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
        long charId = token.getCharId();

        CharModel charModel = charRepository.findById(charId);
        return charModel;
    }

    /** delete char */
    @RequestMapping(value="/api/chars/{charId}", method=RequestMethod.DELETE)
    public SuccessResponse deleteChar(@PathVariable long charId) {
        return new SuccessResponse(false, "not implemented");
    }

}
