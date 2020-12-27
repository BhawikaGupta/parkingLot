package com.squad.stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        ParkingLot parkingLot = new ParkingLot();

        System.out.println("Enter the input file location: ");

        // scanner instance to get the file location
        Scanner sc = new Scanner(System.in);
        //String inputFilePath = sc.nextLine();
        String inputFilePath = "/Users/bhawikagupta/parkingLot/src/com/squad/stack/input.txt";

        try {
            //creating File instance to reference text file in Java
            File text;

            if(inputFilePath == null || inputFilePath.isEmpty()) {
                System.out.println("No file name has been entered. Try again by entering file location");
                return;
            }
            else {
                text = new File(inputFilePath);
            }
            //Updating Scanner instance to read File in Java
            sc = new Scanner(text);

            //Reading each line of file using Scanner class
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] inputLine = line.split(" ");
                // processing different input and calling respective function with required parameters
                switch (inputLine[0]) {
                    case "Create_parking_lot":
                        parkingLot.createParking(Integer.parseInt(inputLine[1]), Integer.parseInt(inputLine[2]));
                        break;
                    case "Park":
                        parkingLot.parkVehicle(inputLine[1], inputLine[3], VehicleType.valueOf(inputLine[4]));
                        break;
                    /*case "Slot_numbers_for_driver_of_age":
                        parkingLot.getSlotNumbersDriverAge(inputLine[1]);
                        break;
                    case "Slot_number_for_car_with_number":
                        parkingLot.getVehicleNumberForSlot(inputLine[1]);
                        break;*/
                    case "Leave":
                        parkingLot.leaveVehicle(inputLine[1],inputLine[2], VehicleType.valueOf(inputLine[3]));
                        break;
                    /*case "Vehicle_registration_number_for_driver_of_age":
                        parkingLot.getVehicleNumberDriverAge(inputLine[1]);
                        break;*/
                    default:
                        System.out.println("Invalid input please check");
                }
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to find file. Try again with correct location");
        }
        catch (Exception ex) {
            System.out.println("Internal error: " + ex.getMessage());
        }
    }
}
