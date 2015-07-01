package com.test.controller;

import com.test.model.MaterialModel;
import com.test.model.User;
import com.test.repository.MaterialRepository;
import com.test.repository.UserRepository;
import com.test.request.AuthRequest;
import com.test.response.AuthResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/api/authenticate", method= RequestMethod.POST)
    public AuthResponse greeting( @RequestBody AuthRequest request) {
        System.out.println(request.name+ ": " + request.password);

        User u = userRepository.findByUsername(request.name);

        if (u != null) {

            // generate jwt
            Key key = MacProvider.generateKey();

            String jwtToken = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS512, key).compact();

            System.out.println(jwtToken);

            return new AuthResponse(true, jwtToken);
        }

        return new AuthResponse(false, null);
    }

}