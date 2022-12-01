package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.DataAlreadyPresentException;
import com.example.HotelManagement.exception.ValidDataException;
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

    @Override
    public List<HotelManagement> getCustomers() {
        return customerList;
    }

    /**
     * @param hotelManagement
     * @return
     * @throws ValidDataException
     * @throws NumberException
     */
    @Override
    public String addCustomer(HotelManagement hotelManagement) throws ValidDataException, NumberException, DataAlreadyPresentException {

        uniqueCheck(hotelManagement.getCustomerNumber());

                hotelManagement.setCustomerName(validation.validateName(hotelManagement.getCustomerName()));


        hotelManagement.setCustomerNumber(validation.validateNumber(hotelManagement.getCustomerNumber()));

        customerList.add(hotelManagement);

        return "customer added";

    }


    /**
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
                break;
            }
        return hotelManagement2;

    }

    /**
     * @param customerId
     * @param hotelManagement
     * @return
     * @throws ValidDataException
     * @throws NumberException
     */
    public HotelManagement updatecustomer(int customerId, HotelManagement hotelManagement) throws ValidDataException, NumberException {
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


        hotelManagement.setCustomerName(validation.validateName(hotelManagement.getCustomerName()));

        hotelManagement.setCustomerNumber(validation.validateNumber(hotelManagement.getCustomerNumber()));


        return hotelManagement2;
    }
    public void uniqueCheck(long customerNumber) throws DataAlreadyPresentException {
        for (HotelManagement hotelM : getCustomers()){
            if(hotelM.getCustomerNumber()==customerNumber)
                throw new DataAlreadyPresentException("Contact already present for Customer : " + hotelM.getCustomerName());
        }
    }


}
