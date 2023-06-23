package com.hotel.hotelproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelproject.entities.UpcomingBooking;
import com.hotel.hotelproject.repo.UpcomingBookingRepo;

@RestController
public class UpcomingBookingController {
	
	@Autowired
	private UpcomingBookingRepo upcomingbookingRepo;
	
	
	//5)List Of Upcoming Bookings
	//http://localhost:8080/upcomingbookings
	@GetMapping("/upcomingbookings")
	public List<UpcomingBooking> getAllUpcomingBookings(){
		return upcomingbookingRepo.findAll();
	}
//	
//	//6)List Of Upcoming Bookings Of A Single Customer
//	//http://localhost:8080/upcomingbookingsOfSingleCustomer/1
//	@GetMapping("/upcomingbookingsOfSingleCustomer/{CustomerId}")
//	public  List<UpcomingBooking> getUpcomingBookingOfCustomer(@PathVariable("CustomerId") int cid){
//		return upcomingbookingRepo.findByCid(cid);
//		
////	}
	
	@GetMapping("/upcomingbookingsofsinglecustomer/{cid}")
	public List<UpcomingBooking> findByCid(@PathVariable("cid") int cid){
		return upcomingbookingRepo.findByCid(cid);
	}

}
