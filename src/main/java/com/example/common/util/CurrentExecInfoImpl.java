package com.example.common.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class CurrentExecInfoImpl implements CurrentExecInfo {

	@Override
	public String getExecName() {

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

}
