package com.example.HotelManagement.service;

import com.example.HotelManagement.controller.HotelController;
import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.*;
import com.example.HotelManagement.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImp {

    List<HotelManagement> customerList = new ArrayList<>();
    Logger logger= LoggerFactory.getLogger(Service.class);
  /* public Service(){
        customerList.add(new HotelManagement("taj",2,"chetan","1234567899","online"));
    } */
    @Autowired
    Validation validation;

    @Override
    public List<HotelManagement> getCustomers() throws EmptyListException {
        if (customerList.isEmpty())
            throw new EmptyListException("List is Empty");
        return customerList;
    }

    /**
     * @param hotelManagement
     * @return
     * @throws ValidDataException
     * @throws NumberException
     */
    @Override
    public HotelManagement addCustomer(HotelManagement hotelManagement) throws ValidDataException, NumberException, DataAlreadyPresentException{
  logger.info("add Started");
        uniqueCheck(hotelManagement.getCustomerNumber(),hotelManagement.getCustomerId());

        hotelManagement.setCustomerName(validation.validateName(hotelManagement.getCustomerName()));
        hotelManagement.setCustomerNumber(validation.validateNumber(hotelManagement.getCustomerNumber()));
        customerList.add(hotelManagement);

        return hotelManagement;

    }
    public HotelManagement searchDataByGivenNumber(Long number){
        validation.validateNumber(number);
        for (HotelManagement hotelManagement:customerList){
            if (hotelManagement.getCustomerNumber()==number){
                return hotelManagement;
            }
        }
        throw new DataNotPresentException("data not present");
    }


    /**
     * @param customerId
     * @return
     */
    @Override
    public HotelManagement deletecustomer(int customerId) throws DataNotPresentException, EmptyListException {
        if (customerList.isEmpty())
            throw new EmptyListException("List is Empty");
        HotelManagement hotelManagement2 = null;
        for (HotelManagement hotelManagement : customerList)
            if (hotelManagement.getCustomerId() == customerId) {
                hotelManagement2 = hotelManagement;
                customerList.remove(hotelManagement);
                break;
            } else
                throw new DataNotPresentException("Given Customer ID does not exist");
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
                hotelManagement1.setCustomerId(hotelManagement.getCustomerId());
                hotelManagement2 = hotelManagement1;
                // break;
            }


        hotelManagement.setCustomerName(validation.validateName(hotelManagement.getCustomerName()));

        hotelManagement.setCustomerNumber(validation.validateNumber(hotelManagement.getCustomerNumber()));


        return hotelManagement2;
    }

    public void uniqueCheck(Long customerNumber,int customerId) throws DataAlreadyPresentException {
        logger.info("u Started");
        for (HotelManagement hotelM : customerList) {
            if (hotelM.getCustomerNumber()==(customerNumber)){
                logger.info("custN");
                throw new DataAlreadyPresentException("Contact already present for Customer : " + hotelM.getCustomerName());
            }

            if (hotelM.getCustomerId()==customerId){
                logger.info("id");
                throw new DataAlreadyPresentException("Id already present for Customer : " + hotelM.getCustomerName());
            }

        }
    }


}
