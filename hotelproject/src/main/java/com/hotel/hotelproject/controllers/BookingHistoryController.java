package com.hotel.hotelproject.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hotel.hotelproject.entities.BookingHistory;
import com.hotel.hotelproject.entities.Customer;
import com.hotel.hotelproject.repo.BookingHistoryRepo;
import com.hotel.hotelproject.repo.CustomerRepo;
import com.hotel.hotelproject.repo.RoomRepo;

@RestController
public class BookingHistoryController {

	@Autowired
	private BookingHistoryRepo bookingRepo;

	@Autowired
	RoomRepo roomRepo;

	//7)Booking history of a Customer
//	@GetMapping("/BookingHistoryByCustomer/{customerId}")
//	public List<BookingHistory> bookingHistoryByCustomer(@PathVariable("customerId") Customer cid) {
//
//		var booking = bookingRepo.findByCustomer(cid);
//		if (booking.isPresent()) {
//			var history = booking.get();
//			return bookingRepo.findByCustomer(history);
//		} else {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer id not found");
//		}
//	}
	
	//7)Booking History Of a Customer
	//http://localhost:8080/BookingHistoryByCustomer/5
	
	@GetMapping("/BookingHistoryByCustomer/{customerId}")
	public List<BookingHistory> bookingHistoryByCustomer(@PathVariable("customerId") Customer cid) {
	return  bookingRepo.findByCustomer(cid);
	}


       //8)Add BookingHistory
		@PostMapping("/bookingHistory")
		public BookingHistory addBookingHistory(@RequestBody BookingHistory bookinghistory) {
				bookingRepo.save(bookinghistory);
				return bookinghistory;
		
	}
		
	//8)Add BookingHistory
	//
//	@PostMapping("/bookinghistory")
//	public BookingHistory addBooking(@RequestBody BookingHistory history) {
//		bookingRepo.save(history);
//		return history;
//	}
	
	//10)Check Out
    //http://localhost:8080/updateroomstatus/544
	@PutMapping("/updateroomstatus/{Room_No}")
	void update(@PathVariable("Room_No") int rno) {
		var r = roomRepo.findById(rno);
		if (r.isPresent()) {
			var beforeStatus = r.get();
			beforeStatus.setStatus("Available");

			var roomnumber = bookingRepo.findByRno(rno);
			if (roomnumber == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room number not found");
			} else {
				roomnumber.setEdate(LocalDate.now());
				bookingRepo.save(roomnumber);
				roomRepo.save(beforeStatus);

			}

		}
	}
}