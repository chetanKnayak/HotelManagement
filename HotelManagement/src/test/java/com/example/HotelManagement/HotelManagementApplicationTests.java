package com.example.HotelManagement;

import com.example.HotelManagement.entites.HotelManagement;
import com.example.HotelManagement.exception.*;
import com.example.HotelManagement.service.Service;
import com.example.HotelManagement.service.ServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
	public void setUpObject() {
		hotelManagement = new HotelManagement();
		hotelManagement.setHotelName("Taj A");
		hotelManagement.setCustomerId(4);
		hotelManagement.setCustomerName("chetan");
		hotelManagement.setCustomerNumber(1234567899L);
		hotelManagement.setPaymentMethod("online");
	}
	@Order(1)
	@Test
	void testAddCustomerData() {
		HotelManagement actual = service.addCustomer(hotelManagement);
		HotelManagement expected = service.searchDataByGivenNumber(hotelManagement.getCustomerNumber());
		assertEquals(expected, actual);
		assertThrows(Exception.class, () -> service.addCustomer(hotelManagement));
	}



	@Order(2)
	@Test
	void testDeleteById() {
		//service.addCustomer(hotelManagement);
		assertThrows(DataNotPresentException.class, () -> service.deletecustomer(6));

	}


	@Order(3)
	@Test
	void testInvalidNameDataForAdd() {
		hotelManagement.setCustomerName("ck");
		hotelManagement.setCustomerId(11);
		hotelManagement.setCustomerNumber(1234456789L);
		assertThrows(ValidDataException.class, () -> service.addCustomer(hotelManagement));
	}

	@Order(4)
	@Test
	void testInvalidNumberDataForAdd() {
		hotelManagement.setCustomerNumber(123456788L);
		hotelManagement.setCustomerId(13);
		assertThrows(NumberException.class, () -> service.addCustomer(hotelManagement));
	}

	@Order(5)
	@Test
	void testPostController() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		hotelManagement.setCustomerNumber(1234567789L);
		hotelManagement.setCustomerId(16);
		this.mockMvc.perform(post("/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(hotelManagement)))
				.andExpect(status().isCreated());
	}


	@Order(6)
	@Test
	void testPutController() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		hotelManagement.setCustomerName("chetan");
		hotelManagement.setHotelName("grand");
		hotelManagement.setPaymentMethod("offline");
		this.mockMvc.perform(put("/Customer/2")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(hotelManagement)))
				.andExpect(status().isCreated());
	}

	@Order(7)
	@Test
	void testdeleteController() throws Exception {

		this.mockMvc.perform(delete("/delete/4")
						.contentType(MediaType.APPLICATION_JSON));

	}
	@Order(8)
	@Test
	void testGetController() throws Exception {
		hotelManagement.setCustomerNumber(1234567899L);
		hotelManagement.setCustomerId(5);
		service.addCustomer(hotelManagement);
		this.mockMvc.perform(get("/Customer")
				.contentType(MediaType.APPLICATION_JSON));

	}

}