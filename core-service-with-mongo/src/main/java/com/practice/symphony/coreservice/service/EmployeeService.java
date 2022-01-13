package com.practice.symphony.coreservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.symphony.coreservice.dao.EmployeeDao;
import com.practice.symphony.coreservice.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee saveEmployee(Employee emp) {
		return employeeDao.saveNewEmployee(emp);
	}
	
	public List<Employee> getEmployeesByTenant(){
		return employeeDao.getAllEmployees();
	}

}
