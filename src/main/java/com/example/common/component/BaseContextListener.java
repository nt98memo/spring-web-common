package com.example.common.component;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class BaseContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
