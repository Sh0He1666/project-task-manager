package com.shohei.tm.app.task;

import javax.validation.*;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy={ CheckDateValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckDate {
	String message() default "{com.shohei.tm.app.task.CheckDate.message}";
	
	Class<?>[]groups() default {};
	
	Class<? extends Payload>[]payload() default {};
	
	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface List {
		CheckDate[]value();
	}
}
