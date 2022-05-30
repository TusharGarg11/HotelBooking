package com.HackerEarth.HotelBooking.Controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HackerEarth.HotelBooking.Dao.UserRepository;
import com.HackerEarth.HotelBooking.Entity.Room;
import com.HackerEarth.HotelBooking.Entity.User;
import com.HackerEarth.HotelBooking.service.AdminService;
import com.HackerEarth.HotelBooking.service.BookingService;
import com.HackerEarth.HotelBooking.service.CustomUserDetails;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/testing")
	public String GetTesting(){
		return "Working";
	}
	
	@PostMapping("/addRooms")
	public ResponseEntity<HttpStatus> addRooms(@RequestBody List<Room> rooms,Principal principal){
		try{
			User user=bookingService.getUserIdByUsername(principal.getName());
			for(Room room:rooms){
				room.setUser(user);
			}
			adminService.addRoomsImpl(rooms);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	 
	@PutMapping("/updateRoom")
	public ResponseEntity<HttpStatus> updateRoomsDetails(@RequestBody List<Room> rooms,Principal principal){
		try{
			User user=bookingService.getUserIdByUsername(principal.getName());
			for(Room room:rooms){
				room.setUser(user);
			}
			adminService.addRoomsImpl(rooms);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms(){
		return adminService.getAllRoomsImpl();
	}
	
	@DeleteMapping("/delete/{roomId}")
	public ResponseEntity<HttpStatus> deleteRoom(@PathVariable String roomId){
		try{
			adminService.deleteRoomsImpl(Integer.parseInt(roomId));
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	

}
