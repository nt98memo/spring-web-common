package com.example.common.validator;

import org.springframework.validation.Errors;

import jakarta.persistence.EntityManager;

public class BaseDeleteValidator extends CommonDeleteValidator {

	public BaseDeleteValidator() {
	}

	public void init(EntityManager entityManager) {
		super.init(entityManager);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		super.validate(target, errors);
	}

}
