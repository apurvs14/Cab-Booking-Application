package com.masai.reopsitory;





import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.TripBooking;
@Repository
public interface TripBookingRepo  extends JpaRepository<TripBooking, Integer>{


	List<TripBooking> findByFromDateTime(LocalDateTime date);


}
