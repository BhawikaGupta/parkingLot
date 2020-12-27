package com.squad.stack;

/*
    Model class for a vehicle information
 */
public class Vehicle {
    String vehicleNumber;
    String vehicleDriverAge;
    VehicleType vehicleType;

    public Vehicle(String vehicleNumber, String vehicleDriverAge, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleDriverAge = vehicleDriverAge;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleDriverAge() {
        return vehicleDriverAge;
    }

    public void setVehicleDriverAge(String vehicleDriverAge) {
        this.vehicleDriverAge = vehicleDriverAge;
    }
}
