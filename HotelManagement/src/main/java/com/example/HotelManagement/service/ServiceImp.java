package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.*;

import java.util.List;

public interface ServiceImp {
    List<HotelManagement> getCustomers() throws EmptyListException;

     HotelManagement addCustomer(HotelManagement hotelManagement) throws ValidDataException, NumberException, DataAlreadyPresentException, EmptyListException;



    HotelManagement deletecustomer(int customerId) throws DataNotPresentException, EmptyListException;

    HotelManagement updatecustomer(int customerId, HotelManagement hotelManagement) throws ValidDataException, NumberException;

    public HotelManagement searchDataByGivenNumber(Long number)throws DataNotPresentException;
}
