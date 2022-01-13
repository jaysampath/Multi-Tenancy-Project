package com.practice.symphony.coreservice.dao;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.practice.symphony.coreservice.entity.Employee;

@Repository
public class EmployeeDao {
	
	
	private final MongoTemplate mongoTemplate;
	
	public EmployeeDao(@Lazy MongoTemplate mongoTemplate) {
		
	    this.mongoTemplate = mongoTemplate;
	  }
	
	public Employee saveNewEmployee(Employee newEmployee) {
		Employee savedEmployee = mongoTemplate.save(newEmployee, "employee");
		System.out.println("inside save in dao:"+savedEmployee);
		return savedEmployee;
	}
	
	public List<Employee> getAllEmployees(){
		Query query = new Query();
		List<Employee> employees = mongoTemplate.find(query, Employee.class, "employee");
		return employees;
	}

}
