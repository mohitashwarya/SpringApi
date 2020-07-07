package com.org.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.org.dto.ExceptionVO;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionVO> handleNullPointerExceptions(NullPointerException ex, WebRequest req){

		ExceptionVO exVo = new ExceptionVO(LocalDate.now(), ex.getMessage(), req.getDescription(false), ex.getClass().toString());
		
		return new ResponseEntity<ExceptionVO>(exVo, HttpStatus.EXPECTATION_FAILED);
		
	}

}
