package com.example.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class DeviceUtil {

	public DeviceUtil() {
	}

	public static String getKind() {

		ServletRequestAttributes reqAttrs = (ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes());
		HttpServletRequest request = reqAttrs.getRequest();
		String userAgent = request.getHeader("user-agent");
		return getKind(userAgent);

	}

	public static String getKind(String userAgent) {

		String regex = "iPhone|iPod|Android.*Mobile|Windows.*Phone|BlackBerry";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(userAgent);
		if (m.find()) {
			return "mb";
		}

		regex = "iPad|Android|Windows.*Touch|Kindle";
		p = Pattern.compile(regex);
		m = p.matcher(userAgent);
		if (m.find()) {
			return "tab";
		}

		return "pc";

	}

	public static String getTplName(String prjName, String className, String methodName) {
		StringBuilder sb = new StringBuilder();
        return sb.append("templates/").append(getKind()).append("/com/example/").append(prjName).append("/").append(className.substring(0, 1).toLowerCase()).append(className.substring(1)).append("/").append(methodName).toString();
	}

}
