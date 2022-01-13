package com.practice.symphony.configservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.symphony.configservice.entity.Config;
import com.practice.symphony.configservice.service.ConfigService;

@RestController
@RequestMapping("/config")
public class ConfigServiceController {
	
	@Autowired
	private ConfigService configService;
	
	@GetMapping("/{id}")
	public Config getConfig(@PathVariable int id) {
		return configService.getConfig(id);
	}
	
	
	@PostMapping("/update")
	public Config getConfig(@RequestBody Config config) {
		return configService.updateConfig(config);
	}

}
