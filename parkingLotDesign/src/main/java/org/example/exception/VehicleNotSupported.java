package org.example.exception;

public class VehicleNotSupported extends RuntimeException{

    @Override
    public String getMessage() {
        return "Don't support this vehicle";
    }
}
