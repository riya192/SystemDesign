package org.example.exception;

public class ParkingLotNotCreatedException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Parking does not exist!";
    }
}
