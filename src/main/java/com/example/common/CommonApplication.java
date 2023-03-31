package com.example.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;

public class CommonApplication {

	public static void start(String[] args, Class<?> clazz, String properties) throws IOException {

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		SpringApplication application = new SpringApplication(clazz);
		Map<String, Object> defaultProperties = new HashMap<>();
		defaultProperties.put("spring.config.name", properties);
		application.setDefaultProperties(defaultProperties);
		application.run(args);

	}

}
