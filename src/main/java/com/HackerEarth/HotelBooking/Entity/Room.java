package com.HackerEarth.HotelBooking.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {
	@Id
	private int roomId;
	private boolean is_Available;
	private long price;
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnore
	private User user;
	
	@ManyToOne
	@JoinColumn(name="bookingId")
	@JsonIgnore
	private Booking booking;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public boolean isIs_Available() {
		return is_Available;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", is_Available=" + is_Available + ", price=" + price + "]";
	}
	public void setIs_Available(boolean is_Available) {
		this.is_Available = is_Available;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
}
