package com.code.employee.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.code.employee.enity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	//Derived Query Methods
	List<Employee> findByName(String name);
	List<Employee> findByDepartmentId(int departmentId);
	List<Employee> findByEmail1(String email);
}