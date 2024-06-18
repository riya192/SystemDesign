package org.example.exception;

public class InvalidCommandException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Invalid Command";
    }
}
