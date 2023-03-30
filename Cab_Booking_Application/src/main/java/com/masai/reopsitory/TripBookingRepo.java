package com.masai.reopsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.TripBooking;
@Repository
public interface TripBookingRepo  extends JpaRepository<TripBooking, Integer>{

	Optional<List<TripBooking>> findByCustomer(int customerld);
	

}
