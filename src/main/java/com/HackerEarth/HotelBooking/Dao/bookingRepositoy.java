package com.HackerEarth.HotelBooking.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HackerEarth.HotelBooking.Entity.Booking;

public interface bookingRepositoy extends JpaRepository<Booking,Integer>{
	@Query("Select b from Booking as b where b.user.userId=:userId")
	public Booking getBookingId(@Param("userId") int userId);
}
