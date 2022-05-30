package com.HackerEarth.HotelBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HackerEarth.HotelBooking.Dao.RoomRepository;
import com.HackerEarth.HotelBooking.Dao.UserRepository;
import com.HackerEarth.HotelBooking.Entity.Room;
import com.HackerEarth.HotelBooking.Entity.User;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private UserRepository userRepository;
	
	public void addRoomsImpl(List<Room> rooms) {
		roomRepository.saveAll(rooms);
	}

	public List<Room> getAllRoomsImpl() {
		return roomRepository.findAll();
	}

	public void deleteRoomsImpl(int roomId) {
		Room room = roomRepository.getById(roomId);
		roomRepository.delete(room);
	}

	public List<User> getAllUserServive() {
		return userRepository.findAll();
	}
	
}
