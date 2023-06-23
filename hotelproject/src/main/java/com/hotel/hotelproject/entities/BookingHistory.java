package com.hotel.hotelproject.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Booking_History")
public class BookingHistory {
	@Id
	@Column(name="Booking_Id")
	private int bid;
	
	@Column(name="Start_Date")
	private LocalDate sdate;
	
	@Column(name="End_Date")
	private LocalDate edate;
	

	
	public BookingHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
     
	
	//BookingHistory to Customer
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Customer_Id")
	private Customer customer;
	
	
	//BookingHistory to Room
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Room_No")
	private Room room;


	@Override
	public String toString() {
		return "BookingHistory [bid=" + bid + ", sdate=" + sdate + ", edate=" + edate + ", customer=" + customer
				+ ", room=" + room + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bid, customer, edate, room, sdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingHistory other = (BookingHistory) obj;
		return bid == other.bid && Objects.equals(customer, other.customer) && Objects.equals(edate, other.edate)
				&& Objects.equals(room, other.room) && Objects.equals(sdate, other.sdate);
	}

	

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public LocalDate getSdate() {
		return sdate;
	}

	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
	}

	public LocalDate getEdate() {
		return edate;
	}

	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	

	public BookingHistory(int bid, LocalDate sdate, LocalDate edate, Customer customer, Room room) {
		super();
		this.bid = bid;
		this.sdate = sdate;
		this.edate = edate;
		this.customer = customer;
		this.room = room;
	}

	//public void setEdate(LocalDate now) {
		//this.edate = edate;
		
	//}

					
	}
