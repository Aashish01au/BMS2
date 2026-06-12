package com.revesion.bms2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revesion.bms2.model.DepartmentModel;
import com.revesion.bms2.repository.DepartmentRepository;
import com.revesion.bms2.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentService;
	
	@Override
	public void addDept(DepartmentModel dept) {
		departmentService.save(dept);
	}

	@Override
	public void deleteDept(int id) {
		departmentService.deleteById(id);
	}

	@Override
	public void updateDept(DepartmentModel dept) {
		departmentService.save(dept);
	}


	@Override
	public List<DepartmentModel> getAllDept() {
		
		return departmentService.findAll();
	}

	@Override
	public DepartmentModel getByIdDept(int id) {

		return departmentService.findById(id).get();
	}

}
