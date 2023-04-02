package com.masai.reopsitory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Customer;
import com.masai.model.TripBooking;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<TripBooking> findBycustomerID(Integer cId);

	
	
}
