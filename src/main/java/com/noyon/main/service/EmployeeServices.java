package com.noyon.main.service;

import java.util.List;

import com.noyon.main.model.Employee;

public interface EmployeeServices {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEployeeById(int id);
	
	Employee updateEmployee(Employee employee, int id);
	
	void deleteEmployee(int id);
	
	List<Employee> findEmployeebyName(String name);
	


}
