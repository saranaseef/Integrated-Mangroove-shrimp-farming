package com.company;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;
import java.io.FileWriter;
import com.opencsv.CSVWriter;

public class GateController implements Observer {
    int gateNumber;
    Boolean isOpen;
    FileWriter fileWriter;

    public GateController(int gateNumber) {
        sendNotification("A new gate is connected");
        this.gateNumber = gateNumber;
        isOpen = false;
        try {
            fileWriter = new FileWriter("/R://Mangrove_Shrimp//Gate Data.csv");
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            // Write the header row
            String[] header = {"Gate Number", "Timestamp"};
            csvWriter.writeNext(header);

            csvWriter.close();
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("File failed to open");
        }
    }

    public void openGate() {  //simulatimg opening the gate
        LocalDateTime openingTime = LocalDateTime.now();
        if(!isOpen) {
            openingTime = LocalDateTime.now();
            sendNotification("Gate " + gateNumber + " is opening at " + openingTime.toString());
            isOpen = true;
        }
        else{
            sendNotification("Gate already open");
        }

        //simulating saving the gate data to the database
        saveGateData(gateNumber, openingTime.toString());
    }

    public void closeGate() { //simulating closing the gate
        LocalDateTime closingTime = LocalDateTime.now();
        if(isOpen) {
            closingTime = LocalDateTime.now();
            sendNotification("Gate " + gateNumber + " is closing at " + closingTime.toString());
            isOpen = true;
        }
        else{
            sendNotification("Gate already closed");
        }

        //simulating saving the gate data to the database
        saveGateData(gateNumber, closingTime.toString());
    }
    private void saveGateData(int gateNumber, String time) { //saving data to database
        // Create a FileWriter object for the CSV file
        try{
            fileWriter = new FileWriter("/R://Mangrove_Shrimp//Gate Data.csv");
            // Create a CSVWriter object with a comma separator
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            // Write some data rows
            String[] string = {String.valueOf(gateNumber), ",", time};
            csvWriter.writeNext(string);

            csvWriter.close();
            fileWriter.close();
        }catch (IOException e){
            System.out.println("File failed to open");
        }

    }

    private void sendNotification(String message) {
        System.out.println(message);
    }

    @Override
    public void update(Observable o, Object arg) {
        //update the gate state to open
        if(!isOpen)
            openGate();
        else
            closeGate();
    }

}
