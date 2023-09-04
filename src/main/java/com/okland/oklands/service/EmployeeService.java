package com.okland.oklands.service;

import java.util.List;

import com.okland.oklands.dto.EmployeeDTO;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO addEmployee(EmployeeDTO employee) throws Exception;
}
