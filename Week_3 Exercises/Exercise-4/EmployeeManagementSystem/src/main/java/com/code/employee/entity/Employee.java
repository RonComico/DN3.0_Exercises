package com.code.employee.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="email",nullable = false, unique = true)
    private String email;
    
//relationship with department one employee can work in many departments
    //under one department there will be multiple employees
    
    @ManyToOne  //relationship manytoone
  //creating the foreign key  department_id  ref to the primary key  of dept 
    @JoinColumn(name = "department_id", nullable = false)        
    private Department department;
    
    
    public Employee() {
    	this.id=0;
    	this.name=null;
    	this.email=null;
    	this.department=null;
    }
  //generate  the getter and setter
  	public int getid() {
  		return id;
  	}
  	public void setid(int id) {
  		this.id = id;
  	}
  	public String getName() {
  		return name;
  	}
  	public void setName(String name) {
  		this.name = name;
  	}
  	public String getEmail() {
  		return email;
  	}
  	public void setEmail(String email) {
  		this.email = email;
  	}

    public Department getDepartment() {
    return department;
    }

    public void setDepartment(Department department) {
    this.department = department;
    }
  	
}