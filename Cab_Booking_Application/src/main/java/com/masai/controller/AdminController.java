package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.TripBooking;
import com.masai.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/")
	public ResponseEntity<Admin> insertAdminHandler(@RequestBody Admin admin) throws AdminException{
		Admin savedAdmin = adminService.saveAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
	}
	
	@DeleteMapping("/{adminId}")
	public ResponseEntity<Admin> deleteMappingHandler(@PathVariable("adminId") Integer adminId) throws AdminException{
		Admin returnAdmin = adminService.delete(adminId);
		return new ResponseEntity<Admin>(returnAdmin,HttpStatus.OK);
	}
	
	@GetMapping("/trips/{customerId}")
	public ResponseEntity<List<TripBooking>> getAllTripsHandler(@PathVariable("customerId") Integer cutomerId) throws AdminException{
		List<TripBooking> trips = adminService.getAllTrips(cutomerId);
		return new ResponseEntity<List<TripBooking>>(trips,HttpStatus.OK);
	}
}
