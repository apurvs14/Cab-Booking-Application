package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CabException;
import com.masai.model.Cab;
import com.masai.service.CabService;

@RestController
public class CabHandler {
	@Autowired
	private CabService cabService;

	@PostMapping("/cab")
	public ResponseEntity<Cab> addCab(@RequestBody Cab cab) throws CabException {
		Cab addedCab = cabService.insertCab(cab);
		return new ResponseEntity<>(addedCab, HttpStatus.CREATED);
	}

	@PatchMapping("/cab/{id}")
	public ResponseEntity<Cab> updateCab(@PathVariable int id, @RequestBody Cab cab) throws CabException {
		cab.setCabID(id);
		Cab updatedCab = cabService.updateCab(cab);
		return new ResponseEntity<>(updatedCab, HttpStatus.OK);
	}

	@DeleteMapping("/cab/{id}")
	public ResponseEntity<Cab> deleteCab(@PathVariable int id) throws CabException {
		Cab deletedCab = cabService.deleteCab(id);
		return new ResponseEntity<>(deletedCab, HttpStatus.ACCEPTED);
	}

	@GetMapping("/cabs")
	public ResponseEntity<List<Cab>> viewCabsOfType(@RequestParam(name = "type") String carType) throws CabException {
		List<Cab> cabs = cabService.viewCabsOfType(carType);
		return new ResponseEntity<>(cabs, HttpStatus.OK);
	}

	@GetMapping("/cab/count")
	public ResponseEntity<Integer> countCabsOfType(@RequestParam(name = "type") String carType) {
		int count = cabService.countCabsOfType(carType);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
}
