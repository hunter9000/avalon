package com.test.util;

import com.test.model.user.Role;
import com.test.model.user.RoleType;
import com.test.model.user.User;
import com.test.security.JwtSubject;

import javax.servlet.http.HttpServletRequest;

public class AuthUtils {

    public static final String JWT_TOKEN_NAME = "jwtToken";
    public static final String CHARACTER_NAME = "character";

    public static boolean isUserAdmin(User user) {
        return userHasRole(user, RoleType.ADMIN);
    }

    public static boolean isUserPlayer(User user) {
        return userHasRole(user, RoleType.PLAYER);
    }

    public static boolean userHasRole(User user, RoleType role) {
        for (Role userrole : user.getRoles()) {
            if (userrole.getRoleName().equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static long getUserId(HttpServletRequest request) {
        return ((JwtSubject)request.getAttribute(JWT_TOKEN_NAME)).getUserId();
    }
}
