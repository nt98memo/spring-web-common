package com.example.common.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.example.common.msg.ErrorMessage;
import com.example.common.util.LogUtil;
import com.example.common.util.WebExceptionUtil;

public class CommonRestControllerAdvice extends CommonControllerAdvice {

	@Autowired
	protected MessageSource messageSource;

	@Autowired
	private LogUtil logUtil;
	
	public CommonRestControllerAdvice() {
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ErrorMessage exceptionHandler(Exception e, WebRequest request) {
		return WebExceptionUtil.exceptionHandler(logUtil, e, request, this.messageSource, null);
	}

}
