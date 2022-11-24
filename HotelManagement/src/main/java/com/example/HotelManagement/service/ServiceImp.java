package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;

import java.util.List;

public interface ServiceImp {
    List<HotelManagement> getCustomers();

    public HotelManagement addCustomer(HotelManagement hotelManagement);



    HotelManagement deletecustomer(int customerId);

    HotelManagement updatecustomer(int customerId, HotelManagement hotelManagement);
}
