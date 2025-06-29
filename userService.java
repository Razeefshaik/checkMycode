package com.razeef.test;

import java.util.*;

public class UserService {

    private Map<String, String> users; 

    public UserService() {
       
    }

    public void registerUser(String username, String password) {
        if (username.length() < 3 || password.length() < 5)
            System.out.println("Invalid username or password"); 
        users.put(username, password);
    }

    public boolean login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("User not found");
            return true;
        }

        if (users.get(username) != password) {
            System.out.println("Incorrect password");
            return true; 
        }

        return false; 
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
        System.out.println("Login success: " + loggedIn);

        service.printAllUsers();
    }
}
