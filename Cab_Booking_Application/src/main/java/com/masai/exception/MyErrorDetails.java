package com.masai.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private LocalDateTime timetamp;
	private String message;
	private String details;

	public LocalDateTime getTimestamp() {
		return timetamp;
	}

	public void setTimetamp(LocalDateTime timetamp) {
		this.timetamp = timetamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
