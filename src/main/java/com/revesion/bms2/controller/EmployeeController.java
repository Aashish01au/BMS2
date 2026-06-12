package com.revesion.bms2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.revesion.bms2.model.EmployeeModel;
import com.revesion.bms2.service.DepartmentService;
import com.revesion.bms2.service.EmployeeService;
import com.revesion.bms2.utils.EmployeeExcelView;
import com.revesion.bms2.utils.EmployeePdfView;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("employee")
	public String getEmp(Model model) {
		model.addAttribute("dList",deptService.getAllDept());
		return"EmployeeForm";
	}
	
	@PostMapping("employee")
	public String postEmp(@ModelAttribute EmployeeModel emp) {
		empService.addEmp(emp);
		return"redirect:/employee";
	}
	
	@GetMapping("empList")
	public String getEmpList(Model model) {
		
		model.addAttribute("eList",empService.getAllEmp());
		return"EmployeeListForm";
	}
	
	@GetMapping("/emp/delete")
	public String deleteEmp(@RequestParam int id) {
		
		empService.deleteEmp(id);
		return"redirect:/empList";
	}
	
	@GetMapping("/emp/edit")
	public String editEmp(@RequestParam int id,Model model) {
		
		model.addAttribute("eModel",empService.getEmpById(id));
		model.addAttribute("dList",deptService.getAllDept());
		
		return"EmployeeEditForm";
	}

	@PostMapping("/emp/update")
	public String updateEmp(@ModelAttribute EmployeeModel emp) {
		
		empService.addEmp(emp);
		
		return"redirect:/empList";
	}
	
	@GetMapping("emp/excel")
	public ModelAndView getExcel() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",empService.getAllEmp());
		mv.setView(new EmployeeExcelView());
		return mv;
	}
	
	@GetMapping("emp/pdf")
	public ModelAndView getPdf() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",empService.getAllEmp());
		mv.setView(new EmployeePdfView());
		
		return mv;
	}
	
}
