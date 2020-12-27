package com.squad.stack;

import java.util.*;


/*
    [1, 3, 2, 4]

    1, 2, 3, 4
 */
public class ParkingFloor {

    //name of the floor
    private String name;

    // data structure to store sorted order of available parking lots
    private final Map<String, TreeSet<String>> availableSlots;

    public ParkingFloor(String name, Map<String, TreeSet<String>> availableSlots) {
        this.name = name;
        this.availableSlots = availableSlots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, TreeSet<String>> getAvailableSlots() {
        return availableSlots;
    }

    public boolean isSlotAvailable(VehicleType vehicleType) {
        if (availableSlots.get(vehicleType.name()).size() > 0) {
            return true;
        }
        return false;
    }

    public void createParking(Integer initialCapacity) {
        for(VehicleType vehicle: VehicleType.values()) {
            // update logic here to get slot
            TreeSet<String> availableSlotVehicle = availableSlots.get(vehicle.name());
            for(int i=1; i<=initialCapacity; i++) {
                availableSlotVehicle.add(String.valueOf(i));
            }
        }
        System.out.println("Created parking of " + initialCapacity + " slots");
    }

    public ParkVehicleResponse parkVehicle(Vehicle vehicle) {
        ParkVehicleResponse parkVehicleResponse = new ParkVehicleResponse();
        if (availableSlots.get(vehicle.getVehicleType().name()).size() == 0) {
            parkVehicleResponse.setErrorMessage("Parking space is full. Please try to come again later!");
            return parkVehicleResponse;
        }
        String slotNumber = availableSlots.get(vehicle.getVehicleType().name()).pollFirst();
        availableSlots.get(vehicle.getVehicleType().name()).remove(slotNumber);
        parkVehicleResponse.setFloor(name);
        parkVehicleResponse.setSlotNumber(slotNumber);
        return parkVehicleResponse;
    }

    public void leaveVehicle(Vehicle vehicle, String slotNumber) {
        if(availableSlots.get(vehicle.vehicleType.name()).contains(slotNumber)) {
            System.out.println("Slot is already there. Vehicle has left");
        }
        else {
            availableSlots.get(vehicle.vehicleType.name()).add(String.valueOf(slotNumber));
        }
    }


}
