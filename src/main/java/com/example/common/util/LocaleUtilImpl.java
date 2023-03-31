package com.example.common.util;

import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class LocaleUtilImpl implements LocaleUtil {

	private static Locale STATIC_LOCALE = Locale.ENGLISH;

	public LocaleUtilImpl() {
	}

	public Locale getRequestLocale() {
		return getRequestLocale(STATIC_LOCALE);
	}

	public Locale getRequestLocale(Locale defaultLocale) {

		Locale locale = defaultLocale;
		try {
			ServletRequestAttributes reqAttrs = (ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes());
			HttpServletRequest request = reqAttrs.getRequest();
			Locale reqLocale = request.getLocale();
			if (reqLocale != null) {
				locale = reqLocale;
			}
		} catch (Exception e) {
			locale = defaultLocale;
		}

		return locale;

	}

}
