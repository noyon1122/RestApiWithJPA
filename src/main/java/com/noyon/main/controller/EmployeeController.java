package com.noyon.main.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.noyon.main.model.Employee;
import com.noyon.main.service.EmployeeService;
import com.noyon.main.service.EmployeeServices;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeServices;

	
	// create employee details
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(this.employeeServices.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	
	//get all employee details
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>>etAllEmployee()
	{
		return new ResponseEntity<List<Employee>>(this.employeeServices.getAllEmployee(),HttpStatus.OK);	
	}
	
	//get employee details by Id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
		return new ResponseEntity<Employee>(this.employeeServices.getEployeeById(id),HttpStatus.OK);
	}

	//update Employee details by id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(this.employeeServices.updateEmployee(employee,id),HttpStatus.OK);
	}
	
	//delete employee by id
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id)
	{
		employeeServices.deleteEmployee(id);
	  return new ResponseEntity<String>("Employee deleted Successfully!",HttpStatus.OK);
	}
	
	//get employee details by 
	
	@GetMapping("/employee/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name)
	{
		return new ResponseEntity<List<Employee>>(this.employeeServices.findEmployeebyName(name),HttpStatus.OK);
	}

}
