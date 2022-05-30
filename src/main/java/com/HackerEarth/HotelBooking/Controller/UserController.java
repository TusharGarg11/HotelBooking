package com.HackerEarth.HotelBooking.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HackerEarth.HotelBooking.Entity.Room;
import com.HackerEarth.HotelBooking.Entity.User;
import com.HackerEarth.HotelBooking.helper.BookingWrapper;
import com.HackerEarth.HotelBooking.service.AdminService;
import com.HackerEarth.HotelBooking.service.BookingService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/bookedRoom")
	public List<Room> getBookedRoom(Principal principal){
		List<Room> rooms=bookingService.getBookedRoomIMPL(principal.getName());
		return rooms;
	}
	
	@PostMapping("/bookedAt")
	public ResponseEntity<HttpStatus> bookedRoomAt(@RequestBody BookingWrapper bookingWrapper,Principal principal){
		try{
			User user=bookingService.getUserIdByUsername(principal.getName());
			bookingService.bookedRoomAtImpl(user, bookingWrapper);
			return new ResponseEntity(HttpStatus.ACCEPTED);	
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);	
		}
	}
	
	
}
