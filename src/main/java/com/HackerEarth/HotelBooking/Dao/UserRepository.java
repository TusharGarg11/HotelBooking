package com.HackerEarth.HotelBooking.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HackerEarth.HotelBooking.Entity.Room;
import com.HackerEarth.HotelBooking.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("Select u from User u where u.username=:username")
	public User getUserByUsername(@Param("username") String username);
}
