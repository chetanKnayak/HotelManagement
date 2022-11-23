package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class Service implements ServiceImp {

    List<HotelManagement> customerList=new ArrayList<>();
    public Service(){
        customerList.add(new HotelManagement(1,"abc","xyz"));
    }
    @Override
    public List<HotelManagement> getCustomers() {
        return customerList;
    }

    @Override
    public HotelManagement addCustomer(HotelManagement hotelManagement) {
       customerList.add(hotelManagement);
        return hotelManagement;

    }
}
