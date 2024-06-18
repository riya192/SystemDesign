package org.example.exception;

public class SlotAlreadyEmptyException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Slot already empty, can unpark!";
    }
}
