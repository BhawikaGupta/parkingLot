package com.squad.stack;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {

    // data structure to store sorted order of available parking lots
    private final Map<String, TreeSet<String>> availableSlots;

    // data structure to keep mapping of slot number with the vehicle present in it
    private final Map<String, Vehicle> parking;

    ParkingLot() {
        availableSlots = new HashMap<>();
        for(VehicleType vehicle: VehicleType.values()) {
            availableSlots.put(vehicle.name(), new TreeSet<>());
        }
        parking = new HashMap<>();
    }

    public void createParking(Integer initialCapacity) {
        for(VehicleType vehicle: VehicleType.values()) {
            TreeSet<String> availableSlotVehicle = availableSlots.get(vehicle.name());
            for(int i=1; i<=initialCapacity; i++) {
                availableSlotVehicle.add(String.valueOf(i));
            }
        }
        System.out.println("Created parking of " + initialCapacity + " slots");
    }

    public void parkVehicle(String vehicleNumber, String driverAge, VehicleType vehicleType) {
        if (availableSlots.get(vehicleType.name()).isEmpty()) {
            System.out.println("Parking space is full. Please try to come again later!");
            return;
        }
        String slotNumber = availableSlots.get(vehicleType.name()).pollFirst();
        Vehicle vehicle = new Vehicle(vehicleNumber,
                slotNumber,
                driverAge, vehicleType);
        parking.put(slotNumber, vehicle);
        System.out.println("Car with registration number "
                + vehicle.vehicleNumber + " has been parked at slot number " + vehicle.vehicleSlot);
    }

    public void  getVehicleNumberForSlot(String vehicleNumber) {
        List<Map.Entry<String, Vehicle>> vehicleList =
        parking.entrySet().stream()
                .filter(a->a.getValue().vehicleNumber.equals(vehicleNumber))
                .collect(Collectors.toList());
        if(vehicleList.isEmpty()) {
            System.out.println("The car with registration number " + vehicleNumber
                    + " is not parked in the parking lot.");
        }
        else {
            System.out.println(vehicleList.get(0).getValue().vehicleSlot);
        }
    }

    public void  getSlotNumbersDriverAge(String driverAge) {
        List<Map.Entry<String, Vehicle>> vehicleList =
                parking.entrySet().stream()
                        .filter(a->a.getValue().vehicleDriverAge.equals(driverAge))
                        .collect(Collectors.toList());
        if(vehicleList.isEmpty()) {
            System.out.println("No car with driver age " + driverAge
                    + " is parked in the parking lot.");
        }
        else {
            List<String> slotList = new ArrayList<>();
            for(Map.Entry<String, Vehicle> entry: vehicleList) {
                slotList.add(entry.getValue().vehicleSlot);
            }
            System.out.println(slotList.toString().replace(", ", ",").replaceAll("[\\[.\\]]", ""));
        }
    }

    public void  getVehicleNumberDriverAge(String driverAge) {
        List<Map.Entry<String, Vehicle>> vehicleList =
                parking.entrySet().stream()
                        .filter(a->a.getValue().vehicleDriverAge.equals(driverAge))
                        .collect(Collectors.toList());
        if(vehicleList.isEmpty()) {
            System.out.println("No car with driver age " + driverAge
                    + " is parked in the parking lot.");
        }
        else {
            List<String> slotList = new ArrayList<>();
            for(Map.Entry<String, Vehicle> entry: vehicleList) {
                slotList.add(entry.getValue().vehicleNumber);
            }
            System.out.println(slotList.toString().replace(", ", ",").replaceAll("[\\[.\\]]", ""));
        }
    }

    public void leaveVehicle(String slotNumber) {
        if(parking.containsKey(slotNumber)) {
            Vehicle vehicle = parking.get(slotNumber);
            parking.remove(slotNumber);
            System.out.println("Slot number " + vehicle.vehicleSlot
                    + " vacated, the car with registration number " + vehicle.vehicleNumber
                    + " has left the space, the driver of the car was of age " + vehicle.vehicleDriverAge);
            availableSlots.get(vehicle.vehicleType.name()).add(String.valueOf(slotNumber));
        }
        else {
            System.out.println("There is no vehicle in slot number " + slotNumber);
        }
    }
}
