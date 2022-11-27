package com.example.HotelManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<String> myMessage(CustomException c){
        return new ResponseEntity<>(c.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       // return new ResponseEntity<>(n.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NumberException.class})
    public ResponseEntity<String> myMessage(NumberException n){
        return new ResponseEntity<>(n.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({NoDataException.class})
    public ResponseEntity<String> myMessage(NoDataException nde){
        return new ResponseEntity<>(nde.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
