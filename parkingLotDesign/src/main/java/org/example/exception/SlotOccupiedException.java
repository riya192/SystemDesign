package org.example.exception;

public class SlotOccupiedException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Slot Already Occupied, please look for other slot!";
    }
}
