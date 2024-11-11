package com.back_end.JobsRocket.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PasswordValidationError extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
}