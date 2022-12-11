package com.example.HotelManagement.exception;

public class DataAlreadyPresentException extends RuntimeException{

    public DataAlreadyPresentException(String message) {
        super(message);
    }
}
