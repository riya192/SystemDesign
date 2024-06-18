package org.example.exception;

public class InvalidSlotNumberException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Invalid Slot Number, Doesn't exist in Parking lot";
    }
}
