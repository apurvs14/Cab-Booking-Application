package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {
	
	public Admin saveAdmin(Admin admin)throws AdminException;
	
	public Admin delete(Integer id)throws AdminException;
}
