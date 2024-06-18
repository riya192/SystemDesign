package org.example.exception;

public class ParkingSlotFullException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Parking lot full! Please come by later!";
    }
}
