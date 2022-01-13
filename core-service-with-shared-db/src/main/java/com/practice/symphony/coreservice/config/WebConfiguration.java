package com.practice.symphony.coreservice.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

  @Bean
  public FilterRegistrationBean<TenantFilter> tenantFilter() {
    FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new TenantFilter());
    registrationBean.addUrlPatterns("/employee/*");
    return registrationBean;
  }
}