package org.example.exception;

public class CarNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Car not found exception";
    }
}
