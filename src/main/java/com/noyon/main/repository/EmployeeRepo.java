package com.noyon.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noyon.main.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	List<Employee> findByName(String name);
}
