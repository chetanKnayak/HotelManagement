package com.example.HotelManagement.validation;

import com.example.HotelManagement.service.Service;
import com.example.HotelManagement.service.ServiceImp;
import org.springframework.stereotype.Component;

@Component
public class Validation {
    ServiceImp service =new Service();

    public Boolean validateName(String name){
        return name.length()<3;
    }








}
