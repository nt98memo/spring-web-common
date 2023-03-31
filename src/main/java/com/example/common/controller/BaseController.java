package com.example.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;


public class BaseController {

	@Value("${app-name}")
    protected String appName;
	
	@Autowired
	protected ApplicationContext context;

	@Autowired
	protected MessageSource messageSource;

	public BaseController() {
	}

}
