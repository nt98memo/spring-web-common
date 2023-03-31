package com.example.common.advice;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import com.example.common.enumeration.Allow;
import com.example.common.enumeration.Deny;
import com.example.common.enumeration.Flg;
import com.example.common.enumeration.UserStatus;
import com.example.common.propertyeditor.AllowEditor;
import com.example.common.propertyeditor.DateEditor;
import com.example.common.propertyeditor.DenyEditor;
import com.example.common.propertyeditor.FlgEditor;
import com.example.common.propertyeditor.OrderDirectionEditor;
import com.example.common.propertyeditor.TimeEditor;
import com.example.common.propertyeditor.TimestampEditor;
import com.example.common.propertyeditor.UserStatusEditor;

public class CommonControllerAdvice {

	@Value("${app-name}")
    protected String appName;
	
	public CommonControllerAdvice() {
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest req) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new DateEditor(req.getLocale()));
		binder.registerCustomEditor(Time.class, new TimeEditor(req.getLocale()));
		binder.registerCustomEditor(Timestamp.class, new TimestampEditor(req.getLocale()));
		binder.registerCustomEditor(Allow.class, new AllowEditor(req.getLocale()));
		binder.registerCustomEditor(Deny.class, new DenyEditor(req.getLocale()));
		binder.registerCustomEditor(Flg.class, new FlgEditor(req.getLocale()));
		binder.registerCustomEditor(OrderDirectionEditor.class, new OrderDirectionEditor(req.getLocale()));
		binder.registerCustomEditor(UserStatus.class, new UserStatusEditor(req.getLocale()));
	}
	
}
