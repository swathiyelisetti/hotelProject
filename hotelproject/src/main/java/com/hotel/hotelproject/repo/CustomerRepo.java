package com.hotel.hotelproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotelproject.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}
