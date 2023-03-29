package com.masai.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
