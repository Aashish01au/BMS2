package com.revesion.bms2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revesion.bms2.model.EmployeeModel;
import com.revesion.bms2.repository.EmployeeRepository;
import com.revesion.bms2.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void addEmp(EmployeeModel emp) {
		empRepo.save(emp);
	}

	@Override
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}

	@Override
	public void updateEmp(EmployeeModel emp) {
		empRepo.save(emp);
	}

	@Override
	public EmployeeModel getEmpById(int id) {

		return empRepo.findById(id).get();
	}

	@Override
	public List<EmployeeModel> getAllEmp() {
	
		return empRepo.findAll();
	}

}
