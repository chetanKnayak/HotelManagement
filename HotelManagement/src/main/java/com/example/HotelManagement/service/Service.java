package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.ValidData;
import com.example.HotelManagement.exception.NoDataException;
import com.example.HotelManagement.exception.NumberException;
import com.example.HotelManagement.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImp {

    List<HotelManagement> customerList = new ArrayList<>();
    @Autowired
    Validation validation;

    /*public Service() {
        customerList.add(new HotelManagement("Grand", 1, "chetan",1234, "Online"));
      customerList.add(new HotelManagement("grand",2,"kumar",567,"online"));
    }*/

    @Override
    public List<HotelManagement> getCustomers() {
        return customerList;
    }

    /**
     *
     * @param hotelManagement
     * @return
     * @throws ValidData
     * @throws NoDataException
     * @throws NumberException
     */
    @Override
    public String addCustomer(HotelManagement hotelManagement) throws ValidData,NoDataException,NumberException {
        if(hotelManagement.getCustomerName()=="")
            throw new NoDataException("ERROR : Customer name cannot be blank");

        if(hotelManagement.getHotelName()=="")
            throw new NoDataException("ERROR : Hotel Name cannot be blank");

        if (validation.validateName(hotelManagement.getCustomerName()))

            throw new ValidData("Enter valid Name");


        if (validation.validateNumber(hotelManagement.getCustomerNumber()))
            throw new NumberException("enter 10 digit number");

        customerList.add(hotelManagement);
        return "customer added";

    }

    /**
     *
     * @param customerId
     * @return
     */
    @Override
    public HotelManagement deletecustomer(int customerId) {
        HotelManagement hotelManagement2 = null;
        for (HotelManagement hotelManagement : customerList)
            if (hotelManagement.getCustomerId() == customerId) {
                hotelManagement2 = hotelManagement;
                customerList.remove(hotelManagement);
               //break;
            }
        return hotelManagement2;

    }

    /**
     *
     * @param customerId
     * @param hotelManagement
     * @return
     * @throws ValidData
     * @throws NoDataException
     * @throws NumberException
     */
    public HotelManagement updatecustomer(int customerId, HotelManagement hotelManagement) throws ValidData, NoDataException, NumberException {
        HotelManagement hotelManagement2 = null;

        for (HotelManagement hotelManagement1 : customerList)

            if (hotelManagement1.getCustomerId() == customerId) {

                hotelManagement1.setCustomerName(hotelManagement.getCustomerName());
                hotelManagement1.setCustomerNumber(hotelManagement.getCustomerNumber());
                hotelManagement1.setHotelName(hotelManagement.getHotelName());
                hotelManagement1.setPaymentMethod(hotelManagement.getPaymentMethod());
                hotelManagement2 = hotelManagement1;
               // break;
            }

        if (validation.validateNumber(hotelManagement.getCustomerNumber()))
            //  return "enter 10 digit number";
            throw new NumberException("enter 10 digit number");

        if(hotelManagement.getCustomerName()=="")
            throw new NoDataException("Blank Field not allowed");

        if (validation.validateName(hotelManagement.getCustomerName()))
            //return "enter valid name";
            throw new ValidData("Enter valid Name");


        return hotelManagement2;
    }

}
