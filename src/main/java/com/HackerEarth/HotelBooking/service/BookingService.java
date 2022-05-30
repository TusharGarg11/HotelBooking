package com.HackerEarth.HotelBooking.service;

import java.util.List;

import com.HackerEarth.HotelBooking.Entity.Booking;
import com.HackerEarth.HotelBooking.Entity.Room;
import com.HackerEarth.HotelBooking.Entity.User;
import com.HackerEarth.HotelBooking.helper.BookingWrapper;

public interface BookingService {
	public User getUserIdByUsername(String username);
	public List<Room> getBookedRoomIMPL(String username);
	public void bookedRoomAtImpl(User user,BookingWrapper bookingWrapper);
	public void updateBookedRoom(List<String> roomIds,Booking booking);
	public void updateBookedTime(List<String> dateList,Booking booking);
}
