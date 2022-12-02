package com.example.HotelManagement.validation;

import com.example.HotelManagement.exception.NumberException;
import com.example.HotelManagement.exception.ValidDataException;
import com.example.HotelManagement.service.Service;
import com.example.HotelManagement.service.ServiceImp;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validation {
    ServiceImp service =new Service();

    public String validateName(String name) throws ValidDataException {
        String regex = "^[a-zA-Z ]*$";
        Pattern validation = Pattern.compile(regex);
      if (!(validation.matcher(name).matches() && name.length()>3))
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
