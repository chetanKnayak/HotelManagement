package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.CustomException;
import com.example.HotelManagement.exception.NumberException;

import java.util.List;

public interface ServiceImp {
    List<HotelManagement> getCustomers();

     String addCustomer(HotelManagement hotelManagement) throws CustomException, NumberException;



    HotelManagement deletecustomer(int customerId);

    HotelManagement updatecustomer(int customerId, HotelManagement hotelManagement);


}
