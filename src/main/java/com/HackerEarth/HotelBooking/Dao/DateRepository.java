package com.HackerEarth.HotelBooking.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HackerEarth.HotelBooking.Entity.Dates;

public interface DateRepository extends JpaRepository<Dates, Integer>{

}
