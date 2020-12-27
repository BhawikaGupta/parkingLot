package com.squad.stack;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {
    private final Map<String, ParkingFloor> parkingFloors;
    private final Map<ParkingSlot, Vehicle> parking;

    public ParkingLot() {
        parkingFloors = new HashMap<>();
        parking = new HashMap<>();
    }

    public void createTicket(Vehicle vehicle, String slotNumber) {

    }

    public ParkingFloor getAvailableFloor(VehicleType vehicleType) {
        for(ParkingFloor floor: parkingFloors.values()) {
            if(floor.isSlotAvailable(vehicleType)) {
                return floor;
            }
        }
        System.out.println("No floor is empty");
        return null;
    }

    public void createParking(Integer initialCapacity, Integer floor) {
        for(int i=1; i<=floor; i++) {
            Map<String, TreeSet<String>> availableSlots = new HashMap<>();
            for(VehicleType vehicle: VehicleType.values()) {
                TreeSet<String> availableSlotVehicle = new TreeSet<>();
                for(int j=1; j<=initialCapacity; j++) {
                    availableSlotVehicle.add(String.valueOf(j));
                }
                availableSlots.put(vehicle.name(), availableSlotVehicle);
            }
            ParkingFloor parkingFloor = new ParkingFloor("Floor" + i, availableSlots);
            parkingFloors.put(parkingFloor.getName(), parkingFloor);
        }
        System.out.println("Created parking of " + initialCapacity + " slots for floor : " + floor);
    }

    public void parkVehicle(String vehicleNumber, String driverAge, VehicleType vehicleType) {
        ParkingFloor parkingFloor = getAvailableFloor(vehicleType);
        if(parkingFloor != null) {
            Vehicle vehicle = new Vehicle(vehicleNumber, driverAge, vehicleType);
            ParkVehicleResponse parkingResponse = parkingFloor.parkVehicle(vehicle);
            ParkingSlot parkingSlot = new ParkingSlot(parkingFloor.getName(), parkingResponse.getSlotNumber(), vehicleType);
            createTicket(vehicle, parkingSlot.getSlotNumber());
            parking.put(parkingSlot, vehicle);
            System.out.println("Car with registration number "
                    + vehicle.vehicleNumber + " has been parked at slot number " + parkingResponse.getSlotNumber()
            + " at floor number " + parkingFloor.getName());
        }
        else {
            System.out.println("No space available to park");
        }

    }

    public void leaveVehicle(String floorNumber, String slotNumber, VehicleType vehicleType) {
        ParkingFloor parkingFloor = parkingFloors.get(floorNumber);
        ParkingSlot parkingSlot = new ParkingSlot(parkingFloor.getName(), slotNumber, vehicleType);
        if(parking.containsKey(parkingSlot)) {
            Vehicle vehicle = parking.get(parkingSlot);
            parkingFloor.leaveVehicle(vehicle, slotNumber);
            parking.remove(parkingSlot);
            System.out.println("Slot number " + slotNumber
                    + " vacated, the car with registration number " + vehicle.vehicleNumber
                    + " has left the space, the driver of the car was of age " + vehicle.vehicleDriverAge);
        }
        else {
            System.out.println("There is no vehicle in slot number " + slotNumber);
        }
    }

    /*public void  getVehicleNumberForSlot(String vehicleNumber) {
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
    }*/


}
