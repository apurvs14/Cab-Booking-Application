package com.masai.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.TripBooking;

public interface TripRepositry  extends JpaRepository<TripBooking, Integer>{
	

}
