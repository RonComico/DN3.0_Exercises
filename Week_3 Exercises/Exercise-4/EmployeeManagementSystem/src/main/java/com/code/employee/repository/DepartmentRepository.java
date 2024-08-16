package com.code.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.employee.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	Department findByName(String name);
}