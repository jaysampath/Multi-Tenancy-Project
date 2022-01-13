package com.practice.symphony.coreservice.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;


@Configurable
public class TenantFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(TenantFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        logger.info("request url= "+String.valueOf(httpRequest.getRequestURI()));
        String tenantId = httpRequest.getHeader("X-Tenant-Id");
        logger.info("id in header : "+tenantId);
        if(tenantId.trim().length()==4){
            int id = Integer.parseInt(tenantId);
            TenantContext.createContext(id);
            logger.info("requested tenant id: "+tenantId);
            chain.doFilter(request,response);
            TenantContext.clear();
        }else {
        	httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        this.destroy();

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
