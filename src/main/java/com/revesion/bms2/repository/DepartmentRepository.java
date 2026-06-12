package com.revesion.bms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revesion.bms2.model.DepartmentModel;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Integer>{

}
