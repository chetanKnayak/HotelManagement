package com.example.HotelManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({ValidData.class})
    public ResponseEntity<String> myMessage(ValidData c){
        return new ResponseEntity<>(c.getMessage(), HttpStatus.BAD_REQUEST);

    }
  /*  @ExceptionHandler(value= ValidData.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public @ResponseBody ErrorResponse   CustomException(ValidData c){
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),c.getMessage());
    }*/


    @ExceptionHandler({NumberException.class})
    public ResponseEntity<String> myMessage(NumberException n){
        return new ResponseEntity<>(n.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({NoDataException.class})
    public ResponseEntity<String> myMessage(NoDataException nde){
        return new ResponseEntity<>(nde.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
