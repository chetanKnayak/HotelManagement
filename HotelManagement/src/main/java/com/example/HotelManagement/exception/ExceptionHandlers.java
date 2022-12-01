package com.example.HotelManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({ValidDataException.class})
    public ResponseEntity<String> myMessage(ValidDataException c){
        return new ResponseEntity<>(c.getMessage(), HttpStatus.BAD_REQUEST);

    }



    @ExceptionHandler({NumberException.class})
    public ResponseEntity<String> myMessage(NumberException n){
        return new ResponseEntity<>(n.getMessage(),HttpStatus.BAD_REQUEST);
    }


}
