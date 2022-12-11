package com.example.HotelManagement;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.DataAlreadyPresentException;
import com.example.HotelManagement.exception.EmptyListException;
import com.example.HotelManagement.exception.NumberException;
import com.example.HotelManagement.exception.ValidDataException;
import com.example.HotelManagement.service.Service;
import com.example.HotelManagement.service.ServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class HotelManagementApplicationTests {
	HotelManagement hotelManagement;
	@Autowired
	ServiceImp service;

	@Autowired
	MockMvc mockMvc;


	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setUpObject(){
		hotelManagement=new HotelManagement();
		hotelManagement.setHotelName("Taj A");
		hotelManagement.setCustomerId(2);
		hotelManagement.setCustomerName("Nikunj");
		hotelManagement.setCustomerNumber("2234567899");
		hotelManagement.setPaymentMethod("online");
	}
	@Order(1)
	@Test
	void testAddCustomerData(){
		HotelManagement actual=service.addCustomer(hotelManagement);
		assertEquals(hotelManagement.getCustomerName(),actual.getCustomerName());
		assertThrows(Exception.class,()->service.addCustomer(hotelManagement));
	}
	@Order(2)
	@Test
	void testDataAlreadyPresentForAdd(){
		hotelManagement.setCustomerNumber("5432167890");
		hotelManagement.setCustomerId(3);
		service.addCustomer(hotelManagement);
		assertThrows(DataAlreadyPresentException.class,()-> service.addCustomer(hotelManagement),"Contact already present for Customer :");
	}

	@Order(3)
	@Test
	void testInvalidNameDataForAdd(){
	hotelManagement.setCustomerName("Ni");
	assertThrows(Exception.class,()-> service.addCustomer(hotelManagement));
	}

	@Order(4)
	@Test
	void testInvalidNumberDataForAdd(){
		hotelManagement.setCustomerNumber("123456788a");
		assertThrows(Exception.class,()->service.addCustomer(hotelManagement));
	}
	@Order(5)
	@Test
	void testPostController() throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		hotelManagement.setCustomerNumber("1234567899");
		this.mockMvc.perform(post("/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(hotelManagement)))
				.andExpect(status().isCreated());
	}



}

