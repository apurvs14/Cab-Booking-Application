package com.masai.reopsitory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.TripBooking;
@Repository
public interface TripBookingRepo  extends JpaRepository<TripBooking, Integer>{

	Optional<List<TripBooking>> findByCustomer(int customerld);
	
	@Query("from trip_booking Group by driverid ORDER BY driverid")
	public List<TripBooking> findByDriverAsc();

	@Query("from trip_booking Order By customer_customerid")
	public List<TripBooking> findByCustomeridAsc();
	
	@Query("from trip_booking Order By from_date_time")
	public List<TripBooking> findByFromDateTimeAsc();
	
	@Query("from trip_booking where customer_customerid=:cId AND from_date_time=:date")
	public List<TripBooking> findByCustomerIdAndFromDateTime(Integer cId,LocalDate date);
}
