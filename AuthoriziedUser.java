package com.example.chattickfront;

public class AuthoriziedUser {

    private static User authoriziedUser;

    public static User getAuthoriziedUser() {
        return authoriziedUser;
    }

    public static void setAuthoriziedUser(User authoriziedUser) {
        AuthoriziedUser.authoriziedUser = authoriziedUser;
    }
}
