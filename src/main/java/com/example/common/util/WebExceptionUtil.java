package com.example.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.WebRequest;

import com.example.common.exception.DemoException;
import com.example.common.msg.ErrorMessage;

public class WebExceptionUtil {

	public WebExceptionUtil() {
	}

	public static String getString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		pw.flush();
		return sw.toString();
	}

	public static ErrorMessage exceptionHandler(LogUtil logUtil, Exception e, WebRequest request, MessageSource messageSource, String fieldHead) {

		if (!(e instanceof DemoException)) {
			logUtil.errorUrl();
			logUtil.writeException(e);
		}

		ErrorMessage message = null;

		try {

			if (e instanceof DemoException) {
				message = getErrorMessage((DemoException) e, request, messageSource, fieldHead);
			} else {
				message = getGlobalErrorMessage(request, messageSource);
			}

		} catch (Exception exception) {
			logUtil.errorUrl();
			logUtil.writeException(exception);
			message = getGlobalErrorMessage(request, messageSource);
		}

		message.writeLog(logUtil);

		return message;

	}

	protected static ErrorMessage getErrorMessage(DemoException demoException, WebRequest request, MessageSource messageSource, String fieldHead) {

		ErrorMessage message = new ErrorMessage();

		for (ObjectError objectError : demoException.getGlobalErrors()) {
			message.setGlobalMsg(messageSource.getMessage(objectError.getCode(), objectError.getArguments(), objectError.getDefaultMessage(), request.getLocale()));
		}
		for (FieldError fieldError : demoException.getFieldErrors()) {
			if (fieldHead == null) {
				message.setFieldMsg(fieldError.getField(), messageSource.getMessage(fieldError.getCode(), fieldError.getArguments(), fieldError.getDefaultMessage(), request.getLocale()));
			} else {
				message.setFieldMsg(fieldError.getField(), messageSource.getMessage(fieldHead + fieldError.getField(), null, null, request.getLocale()) + " : " + messageSource.getMessage(fieldError.getCode(), fieldError.getArguments(), fieldError.getDefaultMessage(), request.getLocale()));
			}
		}

		return message;
	}

	protected static ErrorMessage getGlobalErrorMessage(WebRequest request, MessageSource messageSource) {
		ErrorMessage message = new ErrorMessage();
		message.setGlobalMsg(messageSource.getMessage("app.msg.global.error", null, "error", request.getLocale()));
		return message;
	}

}
