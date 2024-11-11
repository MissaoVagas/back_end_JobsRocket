package com.back_end.JobsRocket.exceptions;

import lombok.Data;

@Data
public class DefaultExceptionResponse {
	
	private Integer statusResponse;
    private String message;
}
