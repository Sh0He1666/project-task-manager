package com.shohei.tm.app.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDateValidator 
	implements ConstraintValidator<CheckDate, TaskForm> {
	private String message;
	
	@Override
	public void initialize(CheckDate constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(TaskForm value, ConstraintValidatorContext context) {
		//入力された年月日が存在するかチェックするメソッド
		try {
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		        String s1 = year + "/" + month + "/" + day;
				//String s1 = value.getDeadLineDate();
		        dtf.format(LocalDate.parse(s1, dtf));
		        return true;
		    } catch (DateTimeParseException dtp) {
		        return false;
		    }	
	}
}
