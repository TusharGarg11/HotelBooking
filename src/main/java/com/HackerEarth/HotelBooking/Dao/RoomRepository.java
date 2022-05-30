package com.HackerEarth.HotelBooking.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HackerEarth.HotelBooking.Entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
	@Query("Select r from Room r where r.roomId=:roomId")
	public Room getRoomDetails(@Param("roomId") int roomId);
	
	@Query("select r from Room as r where r.booking.bookingId=:bookingId")
	public List<Room> getRoomOnBookingId(@Param("bookingId") int bookingId);
}
