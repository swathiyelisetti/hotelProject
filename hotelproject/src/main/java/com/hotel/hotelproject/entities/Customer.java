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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "Customer_Id")
	private int cid;
	
	@Column(name = "Name")
	private String cname;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Mobile")
	private String mobile;
	
	@Column(name = "Gender")
	private String gender;

	// Customer to BookingHistory
	@OneToMany(fetch=FetchType.EAGER,mappedBy="customer")
	@JsonIgnore
	private List<BookingHistory> bookinghistory = new ArrayList<BookingHistory>();

	// Customer to UpcomingBooking
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER,mappedBy="customer")

	private List<UpcomingBooking> upcomingbooking = new ArrayList<UpcomingBooking>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<BookingHistory> getBookinghistory() {
		return bookinghistory;
	}

	public void setBookinghistory(List<BookingHistory> bookinghistory) {
		this.bookinghistory = bookinghistory;
	}

	public List<UpcomingBooking> getUpcomingbooking() {
		return upcomingbooking;
	}

	public void setUpcomingbooking(List<UpcomingBooking> upcomingbooking) {
		this.upcomingbooking = upcomingbooking;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookinghistory, cid, cname, email, gender, mobile, upcomingbooking);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(bookinghistory, other.bookinghistory) && cid == other.cid
				&& Objects.equals(cname, other.cname) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(upcomingbooking, other.upcomingbooking);
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", bookinghistory=" + bookinghistory + ", upcomingbooking=" + upcomingbooking + "]";
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
