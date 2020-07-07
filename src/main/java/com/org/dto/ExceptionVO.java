package com.org.dto;

import java.time.LocalDate;

public class ExceptionVO {
	
	private LocalDate date;
	private String message;
	private String path;
	private String exceptionClass;
	
	public ExceptionVO() {
	}
	
	public ExceptionVO(LocalDate date, String message, String path, String exceptionClass) {
		this.date = date;
		this.message = message;
		this.path = path;
		this.exceptionClass = exceptionClass;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExceptionClass() {
		return exceptionClass;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}
	
}
