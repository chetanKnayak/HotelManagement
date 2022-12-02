package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.*;

import java.util.List;

public interface ServiceImp {
    List<HotelManagement> getCustomers();

     String addCustomer(HotelManagement hotelManagement) throws ValidDataException, NumberException, DataAlreadyPresentException;



    HotelManagement deletecustomer(int customerId) throws DataNotPresentException, EmptyListException;

    HotelManagement updatecustomer(int customerId, HotelManagement hotelManagement) throws ValidDataException, NumberException;


}
