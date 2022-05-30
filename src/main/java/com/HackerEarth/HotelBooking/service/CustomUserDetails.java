package com.HackerEarth.HotelBooking.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.HackerEarth.HotelBooking.Entity.User;

import antlr.collections.List;

public class CustomUserDetails implements UserDetails {

	private User user;
		
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(user.getRole());
		ArrayList<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();
		list.add(simpleGrantedAuthority);
		return list;
	}

	public String getPassword() {
		return user.getPassword();
	}
	
	public int getUserId() {
		return user.getUserId();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
