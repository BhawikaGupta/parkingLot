package com.squad.stack;

/*
    Model class for a vehicle information
 */
public class Vehicle {
    String vehicleNumber;
    String vehicleSlot;
    String vehicleDriverAge;

    public Vehicle(String vehicleNumber, String vehicleSlot, String vehicleDriverAge) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleSlot = vehicleSlot;
        this.vehicleDriverAge = vehicleDriverAge;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleSlot() {
        return vehicleSlot;
    }

    public void setVehicleSlot(String vehicleSlot) {
        this.vehicleSlot = vehicleSlot;
    }

    public String getVehicleDriverAge() {
        return vehicleDriverAge;
    }

    public void setVehicleDriverAge(String vehicleDriverAge) {
        this.vehicleDriverAge = vehicleDriverAge;
    }
}
