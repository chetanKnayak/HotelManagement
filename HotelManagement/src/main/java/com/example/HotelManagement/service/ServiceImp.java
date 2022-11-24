package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;

import java.util.List;

public interface ServiceImp {
    List<HotelManagement> getCustomers();

    public HotelManagement addCustomer(HotelManagement hotelManagement);



    HotelManagement deleteCustomer(int customerId);

    HotelManagement updateCustomer(int customerId, HotelManagement hotelManagement);
}
