package com.revesion.bms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revesion.bms2.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
	UserModel findByEmailAndPassword(String email, String psw);

}
