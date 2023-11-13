package com.example.together.global.security.auth;

public class CurrentUserHolder {

    private static final ThreadLocal<Object> currentUser = new ThreadLocal<>();

    public static Object getUser() {
        return currentUser.get();
    }


}
