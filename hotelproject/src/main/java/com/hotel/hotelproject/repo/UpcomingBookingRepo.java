package com.hotel.hotelproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.hotelproject.entities.UpcomingBooking;

public interface UpcomingBookingRepo extends JpaRepository<UpcomingBooking,Integer>{

//	List<UpcomingBooking> findByCid(int cid);

//	List<UpcomingBooking> findByCustomer_IdByCid(int cid);

//	List<UpcomingBooking> findByCustomerCid(int cid);

//	List<UpcomingBooking> findByCustomer_id(int cid);
	
	//List<UpcomingBooking> findByCustomer(Customer c);
	
	@Query(value="select * from Upcoming_Booking b where b.Customer_Id=?1",nativeQuery=true)
	List<UpcomingBooking> findByCid(int cid);


}
