package com.masai.service;

import java.util.List;

import com.masai.exception.CabNotAvailAble;
import com.masai.model.Cab;

public interface CabService {
	
	
	public List<Cab> getCabs() throws CabNotAvailAble;

}
