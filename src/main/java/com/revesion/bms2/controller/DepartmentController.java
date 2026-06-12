package com.revesion.bms2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revesion.bms2.model.DepartmentModel;
import com.revesion.bms2.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentSevice;
	
	@GetMapping("/department")
	public String getDepartment() {
		return "DepartmentForm";
	}
	
	@PostMapping("/department")
	public String postDepartment(@ModelAttribute DepartmentModel dept) {
		departmentSevice.addDept(dept);
		return"DepartmentForm";
	}
	
	@GetMapping("/deptList")
	public String getDeptList(Model model) {
		model.addAttribute("dList",departmentSevice.getAllDept());
		return"DepartmentListform";
	}
	

	@GetMapping("/dept/delete")
	public String deleteDept(@RequestParam int id) {
		departmentSevice.deleteDept(id);
		return"redirect:/deptList";
	}
	
	@GetMapping("/dept/edit")
	public String editDept(@RequestParam int id,Model model) {
		model.addAttribute("dModel",departmentSevice.getByIdDept(id));
		return "DepartmentEditForm";
	}
	
	@PostMapping("/dept/update")
	public String updateDept(@ModelAttribute DepartmentModel dept) {
		departmentSevice.updateDept(dept);
		return"redirect:/deptList";
	}
}
