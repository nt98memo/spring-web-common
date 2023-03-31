package com.example.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class LogUtilImpl implements LogUtil {

	private static Logger LOG = LoggerFactory.getLogger("com.example.common.info");
	private static Logger WARN_LOG = LoggerFactory.getLogger("com.example.common.warn");
	private static Logger ERROR_LOG = LoggerFactory.getLogger("com.example.common.error");

	public LogUtilImpl() {
	}

	public void trace(String message) {
		LOG.trace(message);
	}

	public void traceUrl() {
		LOG.trace(getUrl());
	}

	public void debug(String message) {
		LOG.debug(message);
	}

	public void debugUrl() {
		LOG.debug(getUrl());
	}

	public void info(String message) {
		LOG.info(message);
	}

	public void infoUrl() {
		LOG.info(getUrl());
	}

	public void warn(String message) {
		LOG.warn(message);
		WARN_LOG.warn(message);
	}

	public void warnUrl() {
		LOG.warn(getUrl());
		WARN_LOG.warn(getUrl());
	}

	public void error(String message) {
		LOG.error(message);
		WARN_LOG.error(message);
		ERROR_LOG.error(message);
	}

	public void errorUrl() {
		LOG.error(getUrl());
		WARN_LOG.error(getUrl());
		ERROR_LOG.error(getUrl());
	}

	public String getUrl() {

		String result = "";

		try {
			ServletRequestAttributes reqAttrs = (ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes());
			HttpServletRequest request = reqAttrs.getRequest();
			String req = request.getRequestURL().toString();
			if (req != null) {
				result = req;
			}
		} catch (Exception e) {
			result = "";
		}

		return result;

	}

	public void writeException(Exception e) {

		StackTraceElement[] traceArray = e.getStackTrace();
		for (StackTraceElement trace : traceArray) {
			error(trace.toString());
		}

	}

}
