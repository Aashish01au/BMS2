package com.revesion.bms2.service;

import java.util.List;

import com.revesion.bms2.model.EmployeeModel;

public interface EmployeeService {

	void addEmp(EmployeeModel emp);
	void deleteEmp(int id);
	void updateEmp(EmployeeModel emp);
	EmployeeModel getEmpById(int id);
	List<EmployeeModel> getAllEmp();
	
}
