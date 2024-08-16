package com.code.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.employee.enity.Department;
import com.code.employee.enity.Employee;

public interface DepartmentRepository extends JpaRepository<Employee,Integer>{
	Department findByName(String name);
}