package com.practice.symphony.configservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="configuration")
public class Config {
	
	@Id
	private int id;
	private int tenantId;
	private String account;
	private String emailExtension;
	public Config(int tenantId, String account, String emailExtension) {
		this.tenantId = tenantId;
		this.account = account;
		this.emailExtension = emailExtension;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmailExtension() {
		return emailExtension;
	}
	public void setEmailExtension(String emailExtension) {
		this.emailExtension = emailExtension;
	}
	
	

}
