package com.squad.stack;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingFloor {

    //name of the floor
    private String name;

    // data structure to store sorted order of available parking lots
    private final Map<String, TreeSet<String>> availableSlots;

    ParkingFloor() {
        availableSlots = new HashMap<>();
        for(VehicleType vehicle: VehicleType.values()) {
            availableSlots.put(vehicle.name(), new TreeSet<>());
        }
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

    public void parkVehicle(Vehicle vehicle) {
        if (availableSlots.get(vehicle.getVehicleType().name()).isEmpty()) {
            System.out.println("Parking space is full. Please try to come again later!");
            return;
        }
        String slotNumber = availableSlots.get(vehicle.getVehicleType().name()).pollFirst();
        return slotNumber;
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
