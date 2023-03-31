package com.example.common.validator;

import org.springframework.validation.Errors;

import jakarta.persistence.EntityManager;

public class BaseUpdateValidator extends CommonUpdateValidator {

	public BaseUpdateValidator() {
	}

	public void init(EntityManager entityManager) {
		super.init(entityManager);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		super.validate(target, errors);
	}

}
