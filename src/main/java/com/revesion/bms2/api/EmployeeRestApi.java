package com.revesion.bms2.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revesion.bms2.model.EmployeeModel;
import com.revesion.bms2.model.Product;
import com.revesion.bms2.model.ProductModel;
import com.revesion.bms2.repository.ProductRepo;
import com.revesion.bms2.repository.ProductRepository;
import com.revesion.bms2.service.EmployeeService;

@RestController
public class EmployeeRestApi {
	
	@Autowired
	private ProductRepo proRepo;
	
	@Autowired
	private ProductRepository prodRepo;

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("api/emp/list")
	public List<EmployeeModel> getEmployeeRestApi() {
		return empService.getAllEmp();
	}
	
	@GetMapping("/api/emp/{id}")
	public EmployeeModel getEmpRestFulApiById(@PathVariable int id) {
		return empService.getEmpById(id);
	}
	
	@PostMapping("api/emp/add")
	public String addEmpRestfulApi(@RequestBody EmployeeModel Emp) {
		empService.addEmp(Emp);
		return "Success";
	}
	
	@PutMapping("api/emp/update")
	public String updateEmpRestFulApi(@RequestBody EmployeeModel emp) {
		empService.addEmp(emp);
		return"update Success";
	}
	
	@DeleteMapping("api/emp/delete/{id}")
	public String deleteEmpRestfulApi(@PathVariable int id) {
		empService.deleteEmp(id);
		return "delete Successful";
	}
	
	@GetMapping("/api/emp/j2o")
	public String getjson2object() {
		
		RestTemplate rTemp = new RestTemplate();
		
		EmployeeModel emp = rTemp.getForObject("http://localhost:8080/api/emp/6", EmployeeModel.class);
		
		return"First Name ="+ emp.getFistname();
	}
	
	@GetMapping("api/emp/ja2oa")
	public String getJsonArrayToObj() {
		  
		RestTemplate rTemp = new RestTemplate();
		EmployeeModel emp[] = rTemp.getForObject("http://localhost:8080/api/emp/list", EmployeeModel[].class);
		
		return "First Name = " + emp[1].getFistname();
	}
	
	@GetMapping("/api/loadProducts")
	public String loadProducts() {
		
		RestTemplate rTemp = new RestTemplate();
		
		System.out.println("1");
		ProductModel[] prod	= rTemp.getForObject("https://fakestoreapi.com/products", ProductModel[].class);

		System.out.println("2");
		prodRepo.saveAll(Arrays.asList(prod));
		
		return "Success";
	}
	
	@GetMapping("/api/product")
	public String product() {
		
		RestTemplate rTemp = new RestTemplate();
		Product[] pro= rTemp.getForObject("https://fakestoreapi.com/products", Product[].class); 
		proRepo.saveAll(List.of(pro));
		return"Success";
	}
	
}
