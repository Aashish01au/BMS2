package com.revesion.bms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revesion.bms2.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer>{

}
