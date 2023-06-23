package com.hotel.hotelproject.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.hotelproject.entities.Room;

public interface RoomRepo extends JpaRepository<Room, Integer> {

	List<Room> findByRoomtype(String roomtype);

	List<Room> findByRoomtypeAndBedtypeAndStatus(String roomtype, String bedtype, String Status);

	@Query(value = "select * from Room", nativeQuery = true)
	public List<Room> getAllRooms();

	@Query("FROM Room r join BookingHistory b ON r.rno = b.room WHERE sdate BETWEEN :startdate AND :enddate and edate IS NOT NULL and roomtype = :type")
	List<Room> countOfType(@Param("startdate") LocalDate sdate, @Param("enddate") LocalDate edate,
			@Param("type") String roomtype);

}
