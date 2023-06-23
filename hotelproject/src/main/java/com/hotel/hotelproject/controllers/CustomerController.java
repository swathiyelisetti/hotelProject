package com.hotel.hotelproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelproject.entities.Customer;
import com.hotel.hotelproject.repo.CustomerRepo;

@RestController
public class CustomerController {
	
	@Autowired
   private CustomerRepo customerrepo;
   
	//2)List Of Customers
	//http://localhost:8080/customers
	@GetMapping("/customers")
	public List<Customer> listofCustomers(){
	  return customerrepo.findAll();
}
}
