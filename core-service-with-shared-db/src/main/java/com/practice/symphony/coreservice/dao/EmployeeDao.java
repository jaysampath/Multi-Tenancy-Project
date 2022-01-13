package com.practice.symphony.coreservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.practice.symphony.coreservice.entity.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private  MongoTemplate mongoTemplate;
	
	
	
	public Employee saveNewEmployee(Employee newEmployee) {
		Employee savedEmployee = mongoTemplate.save(newEmployee, "employee");
		
		return savedEmployee;
	}
	
	public List<Employee> getAllEmployees(int tenantId){
		Query query = new Query();
		query.addCriteria(Criteria.where("tenantId").is(tenantId));
		List<Employee> employees = mongoTemplate.find(query, Employee.class, "employee");
		return employees;
	}

}
