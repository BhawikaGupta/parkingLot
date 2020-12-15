package com.squad.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ParkVehicleResponse {
    String floor;
    String slotNumber;
    String errorMessage;

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
