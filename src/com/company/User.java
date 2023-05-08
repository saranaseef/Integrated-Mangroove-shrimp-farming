package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class User {
    String username;
    String password;
    String pin;
    ShrimpFarm farm = new ShrimpFarm();

    public User(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Boolean login() {
        File file = new File("/R://data.csv");
        String line = "";
        String csvSplitBy = ",";
        Boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] user = line.split(csvSplitBy);
                if (user[0].equals(username) && user[1].equals(password)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found;
    }

    public Boolean authenticate() {
        File file = new File("/R://data.csv");
        String line = "";
        String csvSplitBy = ",";
        Boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] user = line.split(csvSplitBy);
                if (user[0].equals(username) && user[2].equals(pin)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found;
    }
}
