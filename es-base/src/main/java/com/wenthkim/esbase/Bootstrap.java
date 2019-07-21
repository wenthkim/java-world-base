package com.wenthkim.esbase;

public class Bootstrap {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.login("111","222");
    }
}
