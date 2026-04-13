package com.mycompany.myprojectapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

    @Test
    void testValidUsername() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "+27821234567");
        assertTrue(user.checkUsername());
    }

    @Test
    void testInvalidUsernameNoUnderscore() {
        UserAccount user = new UserAccount("johndoe", "Password1!", "+27821234567");
        assertFalse(user.checkUsername());
    }

    @Test
    void testInvalidUsernameTooShort() {
        UserAccount user = new UserAccount("a_b", "Password1!", "+27821234567");
        assertFalse(user.checkUsername());
    }

    @Test
    void testValidPassword() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "+27821234567");
        assertTrue(user.checkPassword());
    }

    @Test
    void testInvalidPasswordTooShort() {
        UserAccount user = new UserAccount("john_doe", "Pass1!", "+27821234567");
        assertFalse(user.checkPassword());
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        UserAccount user = new UserAccount("john_doe", "password1!", "+27821234567");
        assertFalse(user.checkPassword());
    }

    @Test
    void testInvalidPasswordNoNumber() {
        UserAccount user = new UserAccount("john_doe", "Password!", "+27821234567");
        assertFalse(user.checkPassword());
    }

    @Test
    void testInvalidPasswordNoSpecialCharacter() {
        UserAccount user = new UserAccount("john_doe", "Password1", "+27821234567");
        assertFalse(user.checkPassword());
    }

    @Test
    void testValidPhoneNumber() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "+27821234567");
        assertTrue(user.checkPhoneNumber());
    }

    @Test
    void testInvalidPhoneNumber() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "0821234567");
        assertFalse(user.checkPhoneNumber());
    }

    @Test
    void testSuccessfulLogin() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "+27821234567");
        assertTrue(user.loginUser("john_doe", "Password1!"));
    }

    @Test
    void testFailedLoginWrongUsername() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "+27821234567");
        assertFalse(user.loginUser("jane_doe", "Password1!"));
    }

    @Test
    void testFailedLoginWrongPassword() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "+27821234567");
        assertFalse(user.loginUser("john_doe", "WrongPass1!"));
    }

    @Test
    void testSuccessfulRegistration() {
        UserAccount user = new UserAccount("john_doe", "Password1!", "+27821234567");
        assertTrue(user.registerUser());
    }

    @Test
    void testFailedRegistration() {
        UserAccount user = new UserAccount("john", "pass", "0821234567");
        assertFalse(user.registerUser());
    }
}