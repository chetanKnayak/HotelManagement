package com.example.HotelManagement;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.DataAlreadyPresentException;
import com.example.HotelManagement.exception.NumberException;
import com.example.HotelManagement.exception.ValidDataException;
import com.example.HotelManagement.service.Service;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class HotelManagementApplicationTests {
	@Autowired
	private Service service;

	/*@Autowired
	HotelManagement hotelManagement;*/
	@Test
	void contextLoads() {
	}
	@Test
	void addCustomerData() throws ValidDataException, NumberException, DataAlreadyPresentException {
		HotelManagement hotelManagement=new HotelManagement("Taj A",2,"Nikunj","2234567899","online");
		HotelManagement actual=service.addCustomer(hotelManagement);
		assertEquals(hotelManagement.getCustomerName(),actual.getCustomerName());
		assertThrows(Exception.class,()->service.addCustomer(hotelManagement));
	}

}

