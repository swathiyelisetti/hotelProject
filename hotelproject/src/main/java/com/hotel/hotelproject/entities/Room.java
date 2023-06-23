package com.hotel.hotelproject.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Room")
public class Room {
	
	@Id
	@Column(name="Room_No")
	private int rno;
	
	@Column(name="Floor")
	private int floor;
	
	@Column(name="Room_Type")
	private String roomtype;
	
	@Column(name="Bed_type")
	private String bedtype;
	
	@Column(name="Tariff")
	private double tariff;
	
	@Column(name="Status")
	private String status;
	
	//Room to BookingHistory
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER,mappedBy="room")
	List <BookingHistory> bookinghistory =new ArrayList<BookingHistory>();

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	public double getTariff() {
		return tariff;
	}

	public void setTariff(double tariff) {
		this.tariff = tariff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BookingHistory> getBookinghistory() {
		return bookinghistory;
	}

	public void setBookinghistory(List<BookingHistory> bookinghistory) {
		this.bookinghistory = bookinghistory;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(bedtype, bookinghistory, floor, rno, roomtype, status, tariff);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(bedtype, other.bedtype) && Objects.equals(bookinghistory, other.bookinghistory)
				&& floor == other.floor && rno == other.rno && Objects.equals(roomtype, other.roomtype)
				&& Objects.equals(status, other.status)
				&& Double.doubleToLongBits(tariff) == Double.doubleToLongBits(other.tariff);
	}

	@Override
	public String toString() {
		return "Room [rno=" + rno + ", floor=" + floor + ", roomtype=" + roomtype + ", bedtype=" + bedtype + ", tariff="
				+ tariff + ", status=" + status + ", bookinghistory=" + bookinghistory + "]";
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
