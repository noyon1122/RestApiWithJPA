package com.noyon.main.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noyon.main.exception.ResourceNotFoundException;
import com.noyon.main.model.Employee;
import com.noyon.main.repository.EmployeeRepo;



@Service
public class EmployeeService implements EmployeeServices {

	private EmployeeRepo employeeRepo;
	
   
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	//Add Employee
	@Override
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}

	//get All the Employee
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	//get Employee by id
	@Override
	public Employee getEployeeById(int id) {
		// TODO Auto-generated method stub
		 Optional<Employee> employee= employeeRepo.findById(id);
		if(employee.isPresent())
		{
			return employee.get();  //get method return the object 
		}
		else {
			throw new  ResourceNotFoundException("Eployee", "id", id);
		}
	}

	//update employee by id
	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		
		Employee existingEmp=employeeRepo.findById(id).orElseThrow( ()->
			new ResourceNotFoundException("Eployee", "id", id));
		
		existingEmp.setName(employee.getName());
		existingEmp.setDesignation(employee.getDesignation());
		existingEmp.setSalary(employee.getSalary());
		
		employeeRepo.save(existingEmp);
		return existingEmp;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
		employeeRepo.deleteById(id);
		
	}

	//get employee by Name
	
	@Override
	public List<Employee> findEmployeebyName(String name) {
		// TODO Auto-generated method stub
		
		
		return employeeRepo.findByName(name);
	}
	
	
}
