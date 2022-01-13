package com.practice.symphony.coreservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.symphony.coreservice.config.TenantContext;
import com.practice.symphony.coreservice.dao.EmployeeDao;
import com.practice.symphony.coreservice.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee saveEmployee(Employee emp) {
		int tenantId = TenantContext.getTenantId();
		String seqName = tenantId + "_" + Employee.SEQUENCE_NAME;
		long id = SequenceGeneratorService.generateSequence(seqName);
		emp.setId( (tenantId+"_emp_"+id) );
		emp.setTenantId(tenantId);
		return employeeDao.saveNewEmployee(emp);
		
	}
	
	public List<Employee> getEmployeesByTenant(){
		int tenantId = TenantContext.getTenantId();
		return employeeDao.getAllEmployees(tenantId);
	}

}
