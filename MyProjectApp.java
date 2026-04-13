package com.mycompany.myprojectapp;

import java.util.Scanner;

class UserAccount {
    private String username;
    private String password;
    private String phoneNumber;

    public UserAccount(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public boolean checkUsername() {
        return username != null && username.contains("_") && username.length() >= 5;
    }

    public boolean checkPassword() {
        if (password == null) {
            return false;
        }

        boolean longEnough = password.length() >= 8;
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");

        return longEnough && hasUpperCase && hasNumber && hasSpecialChar;
    }

    public boolean checkPhoneNumber() {
        return phoneNumber != null && phoneNumber.matches("\\+27[0-9]{9}");
    }

    public boolean loginUser(String loginUsername, String loginPassword) {
        return username != null && password != null
                && username.equals(loginUsername)
                && password.equals(loginPassword);
    }

    public boolean registerUser() {
        boolean valid = true;

        if (!checkUsername()) {
            System.out.println("Error: Username must contain an underscore and be at least 5 characters long.");
            valid = false;
        }

        if (!checkPassword()) {
            System.out.println("Error: Password must be 8 or more characters long and include a capital letter, number, and symbol.");
            valid = false;
        }

        if (!checkPhoneNumber()) {
            System.out.println("Error: Phone number must start with +27 followed by 9 digits.");
            valid = false;
        }

        return valid;
    }
}

public class MyProjectApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String userNm = input.nextLine();

        System.out.print("Enter password: ");
        String passWd = input.nextLine();

        System.out.print("Enter cellphone number: ");
        String phone = input.nextLine();

        UserAccount user = new UserAccount(userNm, passWd, phone);

        if (user.registerUser()) {
            System.out.println("\nRegistration successful!\n");

            System.out.print("Login Username: ");
            String loginUser = input.nextLine();

            System.out.print("Login Password: ");
            String loginPass = input.nextLine();

            if (user.loginUser(loginUser, loginPass)) {
                System.out.println("Welcome back!");
            } else {
                System.out.println("Invalid credentials.");
            }
        } else {
            System.out.println("\nRegistration failed. Please try again.");
        }

        input.close();
    }
}