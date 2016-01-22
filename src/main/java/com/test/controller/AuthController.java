package com.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.model.User;
import com.test.repository.UserRepository;
import com.test.request.AuthRequest;
import com.test.response.AuthResponse;
import com.test.response.SuccessResponse;
import com.test.security.*;
import com.test.security.SecurityManager;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityManager securityManager;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/authenticate", method= RequestMethod.POST)
    public ResponseEntity<?> greeting( @RequestBody AuthRequest request) {
        System.out.println(request.name+ ": " + request.password);

        User u = userRepository.findByUsername(request.name);

        if (u != null) {

            JwtSubject subject = new JwtSubject();
            subject.setUserId(u.getId());

            String s = null;
            try {
                s = subject.getAsJSON();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return new ResponseEntity<>(new SuccessResponse(false, "Error processing user"), HttpStatus.BAD_REQUEST);
            }

            // generate jwt
            String jwtToken = Jwts.builder().setSubject(s).signWith(SignatureAlgorithm.HS512, securityManager.getSecurityKey()).compact();

            System.out.println(jwtToken);

            return new ResponseEntity<>(new AuthResponse(true, jwtToken), HttpStatus.OK);
//            return new AuthResponse(true, jwtToken);
        }

        // user not found
        return new ResponseEntity<>(new AuthResponse(false, null), HttpStatus.UNAUTHORIZED);
//        return new AuthResponse(false, null);
    }

    @RequestMapping(value="/api/charselect/{charId}", method = RequestMethod.POST)
    public ResponseEntity selectCharacter(@PathVariable long charId) {

        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");

        // TODO verify charId belongs to this user
        token.setCharId(charId);

        String s = null;
        try {
            s = token.getAsJSON();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new SuccessResponse(false, "Error processing user"), HttpStatus.BAD_REQUEST);
        }

        // generate jwt
        String jwtToken = Jwts.builder().setSubject(s).signWith(SignatureAlgorithm.HS512, securityManager.getSecurityKey()).compact();

        System.out.println(jwtToken);

        return new ResponseEntity<>(new AuthResponse(true, jwtToken), HttpStatus.OK);
    }


}