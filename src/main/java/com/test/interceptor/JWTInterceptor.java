package com.test.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.security.JwtSubject;
import com.test.security.SecurityManager;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private SecurityManager securityManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwtToken = request.getHeader("x-access-token");

//        System.out.println(securityManager);
        System.out.println(jwtToken);

        System.out.println("pre handle Request URL::" + request.getRequestURL().toString() + " | token: " + jwtToken);

        // validate the token here
        System.out.println("subject: " + Jwts.parser().setSigningKey(securityManager.getSecurityKey()).parseClaimsJws(jwtToken).getBody().getSubject());//.equals("Joe");

        String jwsSubject = Jwts.parser().setSigningKey(securityManager.getSecurityKey()).parseClaimsJws(jwtToken).getBody().getSubject();

        ObjectMapper objectMapper = new ObjectMapper();
        JwtSubject subject = objectMapper.readValue(jwsSubject, JwtSubject.class);

        request.setAttribute("jwtToken", subject);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("post handle Request URL::" + request.getRequestURL().toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
//        System.out.println("after completion Request URL::" + request.getRequestURL().toString());
    }

}
