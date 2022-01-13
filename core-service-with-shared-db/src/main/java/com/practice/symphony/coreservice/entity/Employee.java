package com.practice.symphony.coreservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
public class Employee {
	
	@Transient
    public static final String SEQUENCE_NAME = "employee_sequence";

	@Id
	private String id;
	private int tenantId;
	private String name;
	private String email;

	public Employee() {

	}

	public Employee(int tenantId, String name, String email) {

		this.tenantId = tenantId;
		this.name = name;
		this.email = email;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", tenantId=" + tenantId + ", name=" + name + ", email=" + email + "]";
	}

	

}
