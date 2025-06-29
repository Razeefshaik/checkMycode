package com.razeef.test;

import java.util.*;

public class UserService {

    private Map<String, String> users;

    public UserService() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (username.length() < 3 || password.length() < 5) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        users.put(username, password);
    }

    public boolean login(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }

        if (!users.get(username).equals(password)) {
            return false;
        }

        return true;
    }

    public void printAllUsers() {
        for (String user : users.keySet()) {
            System.out.println("User: " + user);
        }
    }

    public static void main(String[] args) {
        UserService service = new UserService();

        service.registerUser("ra", "123");
        service.registerUser("razeef", "secret123");

        boolean loggedIn = service.login("razeef", "wrongpassword");
        System.out.println("Login success: " + !loggedIn); // Inverting the boolean for easier reading

        service.printAllUsers();
    }
}