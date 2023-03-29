package com.masai.reopsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Cab;

public interface CabRepo extends JpaRepository<Cab, Integer> {
	List<Cab> findByCarType(String carType);

	int countByCarType(String carType);
}
