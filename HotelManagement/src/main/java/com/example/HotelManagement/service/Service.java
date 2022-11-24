package com.example.HotelManagement.service;

import com.example.HotelManagement.entites.HotelManagement;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImp {

    List<HotelManagement> customerList = new ArrayList<>();

    public Service() {
        customerList.add(new HotelManagement(1, "abc", "xyz"));
        customerList.add(new HotelManagement(4, "chetan", "kar"));
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

    /*@Override
    public HotelManagement updateCustomer(HotelManagement hotelManagement) {
        return null;
    }
*/
   /* @Override
    public HotelManagement updateCustomer(HotelManagement hotelManagement) {

        customerList.stream().filter(hotelManagement1 -> hotelManagement1.getCustomerId() == hotelManagement.getCustomerId()).forEach(hotelManagement1 -> {
            hotelManagement1.setCustomerAddress(hotelManagement.getCustomerAddress());
            hotelManagement1.setCustomerName(hotelManagement.getCustomerName());
        });
        return hotelManagement;
    }*/


    @Override
    public HotelManagement deleteCustomer(int customerId) {
        HotelManagement hotelManagement2 = null;
        for (HotelManagement hotelManagement : customerList)
            if (hotelManagement.getCustomerId() == customerId) {
                hotelManagement2= hotelManagement;
                customerList.remove(hotelManagement);
                break;
            }
        return hotelManagement2;

    }

    public HotelManagement updateCustomer(int customerId, HotelManagement hotelManagement) {
        HotelManagement hotelManagement2 = null;
        for (HotelManagement hotelManagement1 : customerList)
            if(hotelManagement1.getCustomerId()==customerId){

              hotelManagement1.setCustomerName(hotelManagement.getCustomerName());
              hotelManagement1.setCustomerAddress(hotelManagement.getCustomerAddress());
             // hotelManagement1.setCustomerId(customerId);
              hotelManagement2=hotelManagement1;
              break;
            }

        return hotelManagement2;
    }

}
