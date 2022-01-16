package com.practice.symphony.coreservice.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.symphony.coreservice.config.TenantContext;
import com.practice.symphony.coreservice.entity.Employee;
import com.practice.symphony.coreservice.exception.TenantNotFoundException;
import com.practice.symphony.coreservice.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

	@Autowired
	RestTemplate restTemplate;

	public void validateTenantId() {
      int tenantId = TenantContext.getTenantId();
      
      String configClientEndpoint = "http://config-service-from-mongo/config/{id}";
      
      logger.info("started connecting with config client with tenant id - {}",tenantId);
      
      String response = restTemplate.exchange(configClientEndpoint, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
	},tenantId).getBody();
      
      logger.info("recieved response of tenant id - {},is {}",tenantId,response);
      
		JSONParser parser = new JSONParser();
		try {
			JSONObject responseJson = (JSONObject) parser.parse(response);
			Long configId = (Long) responseJson.get("id");
			String configAccount = (String) responseJson.get("account");
			if(configId==0 && configAccount==null) {
				//System.out.println("tenant exception ..");
				throw new TenantNotFoundException("Tenant with id - "+tenantId+" not found. ");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		validateTenantId();
		return employeeService.getEmployeesByTenant();
	}

}
