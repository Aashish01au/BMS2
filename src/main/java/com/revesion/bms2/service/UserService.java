package com.revesion.bms2.service;

import com.revesion.bms2.model.UserModel;

public interface UserService {

	// write all methods here!!!
	 void Signup(UserModel user);
	 UserModel userLogin(String email , String psw);
	 
	
}
