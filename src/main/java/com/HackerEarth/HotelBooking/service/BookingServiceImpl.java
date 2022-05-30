package com.HackerEarth.HotelBooking.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HackerEarth.HotelBooking.Dao.DateRepository;
import com.HackerEarth.HotelBooking.Dao.RoomRepository;
import com.HackerEarth.HotelBooking.Dao.UserRepository;
import com.HackerEarth.HotelBooking.Dao.bookingRepositoy;
import com.HackerEarth.HotelBooking.Entity.Booking;
import com.HackerEarth.HotelBooking.Entity.Dates;
import com.HackerEarth.HotelBooking.Entity.Room;
import com.HackerEarth.HotelBooking.Entity.User;
import com.HackerEarth.HotelBooking.helper.BookingWrapper;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private bookingRepositoy bookingRepo;
	@Autowired
	private DateRepository dateRepository;
	
	
//	Get UserId By UserName
	public User getUserIdByUsername(String username){
		User user=userRepository.getUserByUsername(username);
		return user;
	}
	
//	Update Booked Room Details In Database
	public void updateBookedRoom(List<String> roomIds,Booking booking){
		List<Room> rooms=new ArrayList();
		for(String roomId:roomIds){
			Room room=roomRepository.getRoomDetails(Integer.parseInt(roomId));
			room.setIs_Available(false);
			room.setBooking(booking);
			rooms.add(room);
		}
		roomRepository.saveAll(rooms);
	}

//	Update Time in the Dates Table
	public void updateBookedTime(List<String> dateList,Booking booking){
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			List<Dates> dates=new ArrayList();
			for(String date :dateList){
				Dates d=new Dates();
				d.setDate((Date)formatter.parse(date));
				d.setBooking(booking);
				dates.add(d);
			}
			dateRepository.saveAll(dates);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}

//	Method Call when request Hit for saving data
	public void bookedRoomAtImpl(User user, BookingWrapper bookingWrapper) {
		Booking booking=new Booking();
		booking.setUser(user);
		bookingRepo.save(booking);
		this.updateBookedRoom(bookingWrapper.getRoomIds(),booking);
		this.updateBookedTime(bookingWrapper.getDates(), booking);
	}
	
//	Get all rooms by a User
	public List<Room> getBookedRoomIMPL(String username) {
		User user=userRepository.getUserByUsername(username);
		Booking booking=bookingRepo.getBookingId(user.getUserId());
		List<Room> rooms=roomRepository.getRoomOnBookingId(booking.getBookingId());
		return rooms;
	}
}
