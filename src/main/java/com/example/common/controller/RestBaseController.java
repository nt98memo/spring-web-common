package com.example.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.example.common.msg.ErrorMessage;
import com.example.common.util.LogUtil;
import com.example.common.util.WebExceptionUtil;

public class RestBaseController extends BaseController {

	@Autowired
	private LogUtil logUtil;
	
	protected PlatformTransactionManager transactionManager;
    
    protected TransactionStatus transactionStatus;

	protected String fieldMsgCodeHead;

	public RestBaseController() {
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ErrorMessage exceptionHandler(Exception e, WebRequest request) {
		if (this.transactionManager != null) {
	    	this.transactionManager.rollback(this.transactionStatus);
		}
		return WebExceptionUtil.exceptionHandler(logUtil, e, request, this.messageSource, this.fieldMsgCodeHead);
	}
	
	protected void begin() {

		this.transactionManager = (PlatformTransactionManager) context.getBean("demoTransactionManager");
		DefaultTransactionDefinition trnDefinition = new DefaultTransactionDefinition();
	    this.transactionStatus = this.transactionManager.getTransaction(trnDefinition);
	    
	}

}
