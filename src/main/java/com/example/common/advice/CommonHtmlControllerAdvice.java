package com.example.common.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.example.common.exception.DemoException;
import com.example.common.util.DeviceUtil;
import com.example.common.util.LogUtil;

public class CommonHtmlControllerAdvice extends CommonControllerAdvice {
	
	@Autowired
	private LogUtil logUtil;
	
	public CommonHtmlControllerAdvice() {
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	public String handleSystemException(Exception e, WebRequest request) {

		if (!(e instanceof DemoException)) {
			logUtil.errorUrl();
			logUtil.writeException(e);
		}
		
		return DeviceUtil.getTplName(this.appName, "index", "error");
		
	}

}
