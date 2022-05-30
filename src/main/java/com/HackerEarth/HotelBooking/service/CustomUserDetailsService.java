package com.HackerEarth.HotelBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HackerEarth.HotelBooking.Dao.RoomRepository;
import com.HackerEarth.HotelBooking.Dao.UserRepository;
import com.HackerEarth.HotelBooking.Entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
		
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		Fetching the User Details based on Username
		
		User user=userRepository.getUserByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("User does not exist");
		}
		return new CustomUserDetails(user);
	}

}
