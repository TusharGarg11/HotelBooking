package com.HackerEarth.HotelBooking.service;

import java.util.List;

import com.HackerEarth.HotelBooking.Entity.User;
import com.HackerEarth.HotelBooking.Entity.Room;

public interface AdminService {
	public void addRoomsImpl(List<Room> room);

	public List<Room> getAllRoomsImpl();

	public void deleteRoomsImpl(int roomId);

	public List<User> getAllUserServive();

}
