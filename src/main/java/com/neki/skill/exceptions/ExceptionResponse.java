package com.neki.skill.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class ExceptionResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;

	private String dataHora;
	private String message;
	private String details;
}
