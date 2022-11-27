package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.CustomException;
import com.example.HotelManagement.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImp {

    List<HotelManagement> customerList = new ArrayList<>();
    @Autowired
    Validation validation;

    public Service() {
        customerList.add(new HotelManagement("Grand", 1, "chetan",1234, "Online"));
      customerList.add(new HotelManagement("grand",2,"kumar",567,"online"));
    }

    @Override
    public List<HotelManagement> getCustomers() {
        return customerList;
    }

    @Override
    public String addCustomer(HotelManagement hotelManagement) throws CustomException {
        if (validation.validateName(hotelManagement.getCustomerName()))
            //return "enter valid name";
            throw new CustomException("Enter valid Name");
        hotelManagement.setCustomerName(hotelManagement.getCustomerName());

        if (validation.validateNumber(hotelManagement.getCustomerNumber()))
          //  return "enter 10 digit number";
            throw new CustomException("Enter Valid Number");
        customerList.add(hotelManagement);
        return "customer added";

    }


    @Override
    public HotelManagement deletecustomer(int customerId) {
        HotelManagement hotelManagement2 = null;
        for (HotelManagement hotelManagement : customerList)
            if (hotelManagement.getCustomerId() == customerId) {
                hotelManagement2 = hotelManagement;
                customerList.remove(hotelManagement);
                break;
            }
        return hotelManagement2;

    }

    public HotelManagement updatecustomer(int customerId, HotelManagement hotelManagement) {
        HotelManagement hotelManagement2 = null;
        for (HotelManagement hotelManagement1 : customerList)
            if (hotelManagement1.getCustomerId() == customerId) {

                hotelManagement1.setCustomerName(hotelManagement.getCustomerName());
                hotelManagement1.setCustomerNumber(hotelManagement.getCustomerNumber());
                hotelManagement1.setHotelName(hotelManagement.getHotelName());
                hotelManagement1.setPaymentMethod(hotelManagement.getPaymentMethod());
                hotelManagement2 = hotelManagement1;
                break;
            }

        return hotelManagement2;
    }



}
