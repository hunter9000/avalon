package com.test.util;


import com.test.model.CharModel;
import com.test.model.User;

public class Util {

    public static boolean isAdmin(User user) {
        if (user == null) {
            return false;
        }
//        if (user.roles.whatever()) {
//            return true;
//        }
        return false;
    }

    public static boolean charBelongsToUser(User user, CharModel character) {
        // allow admins to access anyone's char? maybe in future
        if (character == null || user == null) {
            return false;
        }
        if (character.getUser().getId() == user.getId()) {
            return true;
        }
        return false;
    }

}