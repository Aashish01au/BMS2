package com.revesion.bms2.service;

import java.util.List;

import com.revesion.bms2.model.DepartmentModel;

public interface DepartmentService {

	void addDept(DepartmentModel dept);
	void deleteDept(int id);
	void updateDept(DepartmentModel dept);
	DepartmentModel getByIdDept(int id);
	List<DepartmentModel> getAllDept();
	
}
