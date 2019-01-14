package com.casd.controller.web.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
public @interface Authorize {

	public String code() default "";

	public boolean secure() default false;
	
	public enum ResultType {
		JSON, REDIRECT, SCRIPT
	};

	public enum RoleEnum {
		ADMIN, USER
	};
	
	public ResultType type() default ResultType.REDIRECT;

	public RoleEnum role() default RoleEnum.USER;
}
