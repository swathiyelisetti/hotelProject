package com.hotel.hotelproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.hotelproject.entities.BookingHistory;
import com.hotel.hotelproject.entities.Customer;

public interface BookingHistoryRepo extends JpaRepository<BookingHistory,Integer>{

	List<BookingHistory> findByCustomer(Customer  customer);
//	List<BookingHistory>bookingHistoryByCustomer(Customer id);
	
	@Query("from BookingHistory where room.rno=:rid and edate=null")
	BookingHistory findByRno(@Param("rid") int rno);

}
