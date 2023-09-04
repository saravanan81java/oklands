package com.okland.oklands.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.okland.oklands.dto.EmployeeDTO;
import com.okland.oklands.model.Employee;
import com.okland.oklands.repository.EmployeeRepository;
import com.okland.oklands.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> listOfEmployees = employeeRepository.findAll();
		List<EmployeeDTO> employeesDto = listOfEmployees
				.stream().map(emp -> convertEmployeesDto(emp)).collect(Collectors.toList());
		return employeesDto;
	}

	private EmployeeDTO convertEmployeesDto(Employee emp) {
		return new EmployeeDTO(emp.getId(), emp.getName(), emp.getAge());
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employee) throws Exception {
		Employee employeeModel = employeeRepository.findByName(employee.getName());
		if(employeeModel == null) {
			employeeModel =  convertEmployee(employee);
		    employeeRepository.save(employeeModel);
		    employee = convertEmployeesDto(employeeModel);
		}else {
			throw new Exception("Duplicate Employe "+ employee);
		}
		return employee;
	}

	private Employee convertEmployee(EmployeeDTO employee) {
		return new Employee(employee.getId(), employee.getName(), employee.getAge());
	}

}
