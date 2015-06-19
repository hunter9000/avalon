package com.test.controller;

import com.test.model.User;
import com.test.repository.UserRepository;
import com.test.request.AuthRequest;
import com.test.response.AuthResponse;
import com.test.response.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/api/authenticate", method= RequestMethod.POST)
    public AuthResponse greeting( @RequestBody AuthRequest request) {
        System.out.println(request.name+ ": " + request.password);

        User u = userRepository.findByUsername(request.name);

        return new AuthResponse("success", "jwttoken goes here");
    }
}