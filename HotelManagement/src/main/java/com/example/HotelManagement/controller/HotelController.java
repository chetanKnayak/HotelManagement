package com.example.HotelManagement.controller;


import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.service.ServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

Logger logger= LoggerFactory.getLogger(HotelController.class);
    @Autowired
    private ServiceImp serviceImp;


    @GetMapping("/Customer")
    public List<HotelManagement> getCustomers(){
        logger.trace("Method Accessed");
        return this.serviceImp.getCustomers();
    }
   /* @GetMapping("/hotel")
    public List<HotelManagement> getHotelName(){
        return this.serviceImp.getHotelName();
    }
    @GetMapping("/payment")
    public List<HotelManagement> getpaymentMethod(){
        return this.serviceImp.getpaymentMethod();
    }*/

   @PostMapping("/add")
   @ResponseStatus
    public String addCustomer(@RequestBody HotelManagement hotelManagement) throws Exception{
       logger.trace("Post Method Accessed");
       return this.serviceImp.addCustomer(hotelManagement);
    }
    @PutMapping("/Customer/{customerId}")
    public HotelManagement updatecustomer(@PathVariable int customerId,@RequestBody HotelManagement hotelManagement)
    {
        logger.trace("Put Method Accessed");
        return this.serviceImp.updatecustomer(customerId,hotelManagement);
    }
  @DeleteMapping("/delete/{customerId}")
    public HotelManagement deletecustomer(@PathVariable int customerId ){
       logger.trace("Delete Method Accessed");
       return this.serviceImp.deletecustomer(customerId);

  }

}
