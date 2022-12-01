package com.example.HotelManagement.validation;

import com.example.HotelManagement.exception.NumberException;
import com.example.HotelManagement.exception.ValidDataException;
import com.example.HotelManagement.service.Service;
import com.example.HotelManagement.service.ServiceImp;
import org.springframework.stereotype.Component;

@Component
public class Validation {
    ServiceImp service =new Service();

    public String validateName(String name) throws ValidDataException {
      if ( name.length()<3)
        throw new ValidDataException("Enter valid Name");
      return name;
    }


    /**
     *
     * @param number
     * @return
     */
    public long validateNumber(long number) throws NumberException {
        String number1= String.valueOf(number);
       if (number1.length()<10)
        throw new NumberException("enter 10 digit number");
        return number;
    }









}
