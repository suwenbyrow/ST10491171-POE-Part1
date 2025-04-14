package com.mycompany.chatback101;

public class Login1 {

    public static void main(String[] args) {
        Login login = new Login();

        System.out.println("==== Username Format Tests ====");
        System.out.println("Test 1 - Correct Username (kyl_1): " + login.checkUserName("kyl_1"));
        System.out.println("Test 2 - Incorrect Username (kyle!!!!!!!!): " + login.checkUserName("kyle!!!!!!!!"));

        System.out.println("\n==== Password Complexity Tests ====");
        System.out.println("Test 3 - Valid Password (Ch&&sec@ke99!): " + login.checkPasswordComplexity("Ch&&sec@ke99!"));
        System.out.println("Test 4 - Invalid Password (password): " + login.checkPasswordComplexity("password"));

        System.out.println("\n==== Phone Number Format Tests ====");
        System.out.println("Test 5 - Valid Phone Number (+27831234567): " + login.checkCellPhoneNumber("+27831234567"));
        System.out.println("Test 6 - Invalid Phone Number (08966553): " + login.checkCellPhoneNumber("08966553"));

        System.out.println("\n==== Registration Tests ====");
        System.out.println("Test 7 - Successful Registration: " + login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567"));
        System.out.println("Test 8 - Username Error: " + login.registerUser("kyle!!!!!!!!", "Ch&&sec@ke99!", "+27831234567"));
        System.out.println("Test 9 - Password Error: " + login.registerUser("kyl_1", "password", "+27831234567"));
        System.out.println("Test 10 - Phone Number Error: " + login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553"));

        System.out.println("\n==== Login Tests ====");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");  // Ensure user is registered before login
        System.out.println("Test 11 - Login Success: " + login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        System.out.println("Test 12 - Login Fail: " + login.loginUser("wrong_user", "wrong_pass"));
    }
}
