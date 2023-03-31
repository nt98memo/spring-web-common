package com.example.common.validator;

import org.springframework.validation.Errors;

import jakarta.persistence.EntityManager;

public class BaseInsertValidator extends CommonInsertValidator {

	public BaseInsertValidator() {
	}

	public void init(EntityManager entityManager) {
		super.init(entityManager);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		super.validate(target, errors);
	}

}
