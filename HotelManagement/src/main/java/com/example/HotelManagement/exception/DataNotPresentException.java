package com.example.HotelManagement.exception;

public class DataNotPresentException extends RuntimeException{
    public DataNotPresentException(String message) {
        super(message);
    }
}
