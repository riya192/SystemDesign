package org.example.exception;

public class ParkingLotAlreadyExistException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Parking lot already exists";
    }
}
