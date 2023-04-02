package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CabException;
import com.masai.model.Cab;
import com.masai.reopsitory.CabRepo;
import com.masai.reopsitory.DriverRepository;

@Service
public class CabServiceImpl implements CabService {
	@Autowired
	private CabRepo cabrepo;
	@Autowired
	private DriverRepository driverrepo;

	@Override
	public Cab insertCab(Cab cab) throws CabException {
		if (cabrepo.existsById(cab.getCabID())) {
			throw new CabException("Cab with id " + cab.getCabID() + " already exists");
		}
		return cabrepo.save(cab);
	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {
		if (!cabrepo.existsById(cab.getCabID())) {
			throw new CabException("Cab with id " + cab.getCabID() + " not found");
		}
		return cabrepo.save(cab);
	}

	@Override
	public Cab deleteCab(int cabId) throws CabException {
		Cab cab = cabrepo.findById(cabId).orElseThrow(() -> new CabException("Cab with id " + cabId + " not found"));
		cabrepo.delete(cab);
		return cab;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {
		return cabrepo.findByCarType(carType);
	}

	@Override
	public int countCabsOfType(String carType) {
		return cabrepo.countByCarType(carType);
	}

}
