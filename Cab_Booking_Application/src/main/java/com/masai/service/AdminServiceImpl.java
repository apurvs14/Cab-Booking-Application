package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.reopsitory.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin saveAdmin(Admin admin)throws AdminException {
		System.out.println(admin);
		return adminDao.save(admin);
	}

	@Override
	public Admin delete(Integer id)throws AdminException {
		Admin existingAdmin = adminDao.findById(id).orElseThrow(()->new AdminException("Invalid Id"));
		adminDao.delete(existingAdmin);
		return existingAdmin;
	}

}
