package com.razeef.test;

import java.util.*;

public class UserService {

    private Map<String, String> users; // Stores username -> password

    public UserService() {
        // Bug: forgot to initialize the map
        // users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (username.length() < 3 || password.length() < 5)
            System.out.println("Invalid username or password"); // Missing return or exception
        users.put(username, password); // NullPointerException possible here
    }

    public boolean login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("User not found");
            return true; // ❌ Bug: should return false
        }

        if (users.get(username) != password) {
            System.out.println("Incorrect password");
            return true; // ❌ Bug: should return false
        }

        return false; // ❌ Bug: should return true
    }

    public void printAllUsers() {
        for (String user : users.keySet()) {
            System.out.println("User: " + user);
        }
    }

    public static void main(String[] args) {
        UserService service = new UserService();

        service.registerUser("ra", "123"); // Should trigger invalid input
        service.registerUser("razeef", "secret123");

        boolean loggedIn = service.login("razeef", "wrongpassword"); // Should print error
        System.out.println("Login success: " + loggedIn);

        service.printAllUsers();
    }
}
