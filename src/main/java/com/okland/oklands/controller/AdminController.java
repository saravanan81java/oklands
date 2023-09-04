package com.okland.oklands.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okland.oklands.dto.EmployeeDTO;
import com.okland.oklands.service.EmployeeService;

@RestController
public class AdminController {
	
	@Autowired
	EmployeeService departmentServiceImpl;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping(){
		return new ResponseEntity<String>("Ok",HttpStatus.OK);
	}
	
	@GetMapping("/allEmployees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		List<EmployeeDTO> listOfEmployees = departmentServiceImpl.getAllEmployees();
		return new ResponseEntity<List<EmployeeDTO>>(listOfEmployees, HttpStatus.OK);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) throws Exception{
		EmployeeDTO employeeDTO = departmentServiceImpl.addEmployee(employee);
		return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
	}

}
