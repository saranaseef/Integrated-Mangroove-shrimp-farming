package com.company;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GateController gate = new GateController(1);
        gate.openGate();
//        String name, password;
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter username: ");
//        name = in.nextLine();
//        System.out.println("Enter password: ");
//        password = in.nextLine();
//        User user = new User(name, password);
//        Boolean login;
//        login = user.login();
//        if(login){
//            System.out.println("This is a two-factor authentication system.\nEnter pin: ");
//            String pin = in.nextLine();
//
//            user.setPin(pin);
//
//            Boolean authenticate = false;
//            authenticate = user.authenticate();
//            if(authenticate)
//                System.out.println("Login successful");
//            else System.out.println("Login failed");
//        }
//        else System.out.println("Login denied");
//
    }
}