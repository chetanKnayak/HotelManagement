package com.example.HotelManagement.controller;


import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.service.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private ServiceImp serviceImp;


    @GetMapping("/Customer")
    public List<HotelManagement> getCustomers(){
        return this.serviceImp.getCustomers();
    }
   /* @PostMapping("/add"){
        public HotelManagement addCustomer(@RequestBody HotelManagement hotelManagement){
            return this.serviceImp.addCustomer(hotelManagement);
        }*/
   @PostMapping("/add")
    public HotelManagement addCustomer(@RequestBody HotelManagement hotelManagement){
       return this.serviceImp.addCustomer(hotelManagement);
    }
}
