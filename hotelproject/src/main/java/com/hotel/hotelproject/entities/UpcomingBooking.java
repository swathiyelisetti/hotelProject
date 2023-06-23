package com.hotel.hotelproject.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Upcoming_Booking")
public class UpcomingBooking {
	@Id
	@Column(name = "Upcoming_Id")
	private int uid;
	
	@Column(name = "Start_Date")
	private LocalDate sdate;
	
	@Column(name = "Room_Type")
	private String roomtype;
	
	@Column(name = "Bed_Type")
	private String bedtype;
	
	@Column(name = "Number_Of_Rooms")
	private int noofrooms;

	@JsonIgnore
//UpcomingBooking to Customer
   @ManyToOne
   @JoinColumn(name="Customer_Id")
   private Customer customer;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public LocalDate getSdate() {
		return sdate;
	}

	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
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

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bedtype, customer, noofrooms, roomtype, sdate, uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpcomingBooking other = (UpcomingBooking) obj;
		return Objects.equals(bedtype, other.bedtype) && Objects.equals(customer, other.customer)
				&& noofrooms == other.noofrooms && Objects.equals(roomtype, other.roomtype)
				&& Objects.equals(sdate, other.sdate) && uid == other.uid;
	}

	@Override
	public String toString() {
		return "UpcomingBooking [uid=" + uid + ", sdate=" + sdate + ", roomtype=" + roomtype + ", bedtype=" + bedtype
				+ ", noofrooms=" + noofrooms + ", customer=" + customer + "]";
	}
	
	//@Column(name = "customer_id")
	//private int customerId;
	
	

}