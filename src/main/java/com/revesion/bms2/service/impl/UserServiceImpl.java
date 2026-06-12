package com.revesion.bms2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revesion.bms2.model.UserModel;
import com.revesion.bms2.repository.UserRepository;
import com.revesion.bms2.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void Signup(UserModel user) {
		userRepo.save(user);
	}

	@Override
	public UserModel userLogin(String email, String psw) {
		
		return userRepo.findByEmailAndPassword(email, psw);
	}

}
