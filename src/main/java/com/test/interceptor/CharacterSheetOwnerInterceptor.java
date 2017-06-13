package com.test.interceptor;

import com.test.model.CharModel;
import com.test.model.user.User;
import com.test.repository.CharRepository;
import com.test.repository.UserRepository;
import com.test.security.JwtSubject;
import com.test.util.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CharacterSheetOwnerInterceptor implements HandlerInterceptor {

    @Autowired
    private CharRepository characterSheetRepository;

    @Autowired
    private UserRepository userRepository;

    /** Validates that the character being requested is owned by the logged in user. Only applies if the @CharacterSheetOwnerRequired annotation is on the method */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // check the annotation on the handler method. if @CharacterSheetOwnerRequired isn't present, return true
        System.out.println(handler.getClass());
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CharacterSheetOwnerRequired characterSheetOwnerRequired = handlerMethod.getMethod().getAnnotation(CharacterSheetOwnerRequired.class);
        if (characterSheetOwnerRequired == null) {
            return true;
        }

        // admin and dm users can access anyone's character sheets
        JwtSubject subject = (JwtSubject)request.getAttribute(AuthUtils.JWT_TOKEN_NAME);
        User user = userRepository.findOne(subject.getUserId());

        // get the character id from the request
        String charId = parseCharId(request.getRequestURI());

        // return error if parameter is null or empty
        if (charId == null || charId.isEmpty()) {
            System.out.println("Invalid charId presented: " + charId + " at " + request.getRequestURI());
            throw new IllegalAccessException();
        }

        // parse to Long
        Long charIdl = null;
            try {
            charIdl = Long.valueOf(charId);
        }
        catch (NumberFormatException nfe) {
            System.out.println("Invalid charId presented: " + charId + " at " + request.getRequestURI());
            throw new IllegalAccessException();
        }

        System.out.println("Character sheet owner interceptor received "+ charId + " for " + request.getRequestURI());

        // validate that the character sheet belongs to the logged in user (admin and dm users can access anyone's sheet)
        CharModel sheet = characterSheetRepository.findOne(charIdl);
        if (sheet == null) {
            throw new IllegalAccessException();
        }
        if (!AuthUtils.isUserAdmin(user)) {        // if just a player, check ownership
            if (subject.getUserId() != sheet.getUser().getId().longValue()) {
                System.out.println("Error: character not owned by user. character " + charId + " user " + subject.getUserId());
                throw new IllegalAccessException();
            }
        }

        // store charsheet in request so controllers can access it without looking up again
        request.setAttribute(AuthUtils.CHARACTER_NAME, sheet);
        return true;
    }

    private String parseCharId(String uri) {
        if (uri.startsWith("/api/char/")) {
            String[] parts = uri.split("/");
            return parts[3];
        }
        else {
            return null;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
