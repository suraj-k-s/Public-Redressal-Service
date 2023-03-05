package com.pg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.entity.User;
import com.pg.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userDao;
	
	
	public User findByUser(String email) {
		return userDao.findByEmail(email);
	}
	
}
