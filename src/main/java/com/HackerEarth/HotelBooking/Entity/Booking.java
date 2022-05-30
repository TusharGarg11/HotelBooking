package com.HackerEarth.HotelBooking.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy="booking",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Room> rooms;
	
	@OneToMany(mappedBy="booking",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Dates> date;
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
}
