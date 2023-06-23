package com.hotel.hotelproject.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hotel.hotelproject.entities.Room;
import com.hotel.hotelproject.repo.RoomRepo;

@RestController
public class RoomController {

	@Autowired
	private RoomRepo roomRepo;

	//1)List Of Rooms
	// http://localhost:8080/rooms
	@GetMapping("/rooms")
	public List<Room> getAllRooms() {
		return roomRepo.getAllRooms();
	}

	//3)List Of Rooms in a GivenType
	// http://localhost:8080/getrooms/Deluxe
	@GetMapping("/getrooms/{roomtype}")
	public List<Room> getRoomsByRoomType(@PathVariable("roomtype") String roomtype) {

		return roomRepo.findByRoomtype(roomtype);
	}
	
	//4)List Of Rooms By Given RoomType And BedType And Currently Available
	//http://localhost:8080/getroomsbyRoomtypeAndBedtypeAndAvailable/Deluxe/Queen
	@GetMapping("getroomsbyRoomtypeAndBedtypeAndAvailable/{roomtype}/{bedtype}")
    public List<Room> roomsByGivenRoomtypeAndBedtypeAndAvailable(@PathVariable("roomtype") String roomtype,
    		@PathVariable("bedtype") String bedtype,String Status){
		return roomRepo.findByRoomtypeAndBedtypeAndStatus(roomtype,bedtype,"Available");
	}
	
	//9)Change 
	@PutMapping("/RoomStatus/{Room_No}")
	public Room update(@PathVariable("Room_No") int rno, @RequestParam("Status") String status) {
	var cat = roomRepo.findById(rno);
	if (cat.isPresent()) {
	var room = cat.get();
	room.setStatus(status);
	roomRepo.save(room);
	return room;
	} else
	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "room number is Not Found");
	}
	
	//11)Count number of available rooms
	//http://localhost:8080/room/AvailbleRooms/2016-09-10/2022-10-15/Deluxe
	@GetMapping("/room/AvailbleRooms/{startDate}/{endDate}/{type}")
	public int availabelRooms(@PathVariable("startDate") LocalDate sdate,@PathVariable("endDate") LocalDate edate,@PathVariable("type") String roomtype) {
	return roomRepo.countOfType(sdate,edate,roomtype).size();
	}
}
