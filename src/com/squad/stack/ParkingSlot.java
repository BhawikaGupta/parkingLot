package com.squad.stack;

import java.util.Objects;

public class ParkingSlot {
    String floor;
    String slotNumber;
    VehicleType vehicleType;

    public ParkingSlot(String floor, String slotNumber, VehicleType vehicleType) {
        this.floor = floor;
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSlot that = (ParkingSlot) o;
        return floor.equals(that.floor) &&
                slotNumber.equals(that.slotNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor, slotNumber);
    }
}
