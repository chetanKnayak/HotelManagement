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
   /* @GetMapping("/hotel")
    public List<HotelManagement> getHotelName(){
        return this.serviceImp.getHotelName();
    }
    @GetMapping("/payment")
    public List<HotelManagement> getpaymentMethod(){
        return this.serviceImp.getpaymentMethod();
    }*/

   @PostMapping("/add")
    public String addCustomer(@RequestBody HotelManagement hotelManagement){
       return this.serviceImp.addCustomer(hotelManagement);
    }
    @PutMapping("/Customer/{customerId}")
    public HotelManagement updatecustomer(@PathVariable int customerId,@RequestBody HotelManagement hotelManagement)
    {
        return this.serviceImp.updatecustomer(customerId,hotelManagement);
    }
  @DeleteMapping("/delete/{customerId}")
    public HotelManagement deletecustomer(@PathVariable int customerId ){
       return this.serviceImp.deletecustomer(customerId);

  }

}
