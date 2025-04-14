/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Progchatback;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class ProgChatBack {

    public static void main(String[] args) {


class Message {
    String text;
    boolean isSent;
    boolean isReceived;
    boolean isRead;

    public Message(String text) {
        this.text = text;
        this.isSent = false;
        this.isReceived = false;
        this.isRead = false;
    }

    public void sendMessage() {
        this.isSent = true;
        System.out.println("Message sent: " + text);
    }

    public void receiveMessage() {
        if (isSent) {
            this.isReceived = true;
            System.out.println("Message received.");
        }
    }

    public void readMessage() {
        if (isReceived) {
            this.isRead = true;
            System.out.println("Message read: " + text);
        }
    }
}

class User {
    String firstName;
    String lastName;
    String username;
    String password;
    String phoneNumber;

    public User(String firstName, String lastName, String username, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void welcomeUser() {
        System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
    }
}

class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedPhone;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 20;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~-].*");
        boolean isLengthOk = password.length() >= 8;

        return hasUpper && hasDigit && hasSpecial && isLengthOk;
    }

    public boolean checkCellPhoneNumber(String phone) {
        // South African format starts with +27 and must be followed by 9 digits (e.g. +27831234567)
        return phone.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String username, String password, String phone) {
        if (!checkUserName(username)) {
            return "Username is incorrectly formatted. It must contain an underscore (_) and be no more than 20 characters.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }

        if (!checkCellPhoneNumber(phone)) {
            return "Phone number must start with +27 and contain 9 digits after it (e.g. +27831234567).";
        }

        this.storedUsername = username;
        this.storedPassword = password;
        this.storedPhone = phone;

        return "User has been registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }

    public String returnLoginStatus(boolean success) {
        return success ? "Login successful. Welcome back!" : "Login failed. Incorrect username or password.";
    }
}

public class ChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        // Input user details
        System.out.print("Enter your First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("First Name successfully added.");

        System.out.print("Enter your Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Last Name successfully added.");

        System.out.print("Create a Username (must contain _ and be under 20 characters): ");
        String username = scanner.nextLine();
        System.out.println("Username successfully added.");

        System.out.print("Create a Password (min 8 chars, capital letter, number, special char): ");
        String password = scanner.nextLine();
        System.out.println("Password successfully added.");

        System.out.print("Enter your Cellphone Number (e.g., +27831234567): ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Cellphone Number successfully added.");

        // Try to register user
        String registrationMsg = login.registerUser(username, password, phoneNumber);
        System.out.println(registrationMsg);

        if (registrationMsg.equals("User has been registered successfully.")) {
            User user = new User(firstName, lastName, username, password, phoneNumber);
            System.out.println();
            user.welcomeUser();

            // Attempt login
            System.out.println("\nPlease log in below.");

            System.out.print("Username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Password: ");
            String loginPassword = scanner.nextLine();

            boolean isLoggedIn = login.loginUser(loginUsername, loginPassword);
            String loginStatus = login.returnLoginStatus(isLoggedIn);
            System.out.println(loginStatus);

            if (isLoggedIn) {
                System.out.println("\nType a message to send:");
                String messageText = scanner.nextLine();

                Message message = new Message(messageText);
                message.sendMessage();
                message.receiveMessage();
                message.readMessage();
            }
        }

        scanner.close();
    }
}

    }
