package com.example.HotelManagement.controller;


import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.DataNotPresentException;
import com.example.HotelManagement.exception.EmptyListException;
import com.example.HotelManagement.service.ServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

Logger logger= LoggerFactory.getLogger(HotelController.class);
    @Autowired
    private ServiceImp serviceImp;

    /**
     *
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/Customer")
    public List<HotelManagement> getCustomers()throws EmptyListException{
        logger.info("Method Accessed");
        return this.serviceImp.getCustomers();
    }

    @ResponseStatus(HttpStatus.CREATED)
   @PostMapping("/add")

    public HotelManagement addCustomer(@RequestBody HotelManagement hotelManagement) throws Exception{
       logger.info("Post Method Accessed");
       return this.serviceImp.addCustomer(hotelManagement);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/Customer/{customerId}")
    public HotelManagement updatecustomer(@PathVariable int customerId,@RequestBody HotelManagement hotelManagement) throws Exception
    {
        logger.info("Put Method Accessed");
        return this.serviceImp.updatecustomer(customerId,hotelManagement);
    }
    @ResponseStatus(HttpStatus.CREATED)
  @DeleteMapping("/delete/{customerId}")
    public HotelManagement deletecustomer(@PathVariable int customerId ) throws DataNotPresentException, EmptyListException {
       logger.info("Delete Method Accessed");
       return this.serviceImp.deletecustomer(customerId);

  }

}
