package com.neki.skill.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TokenGenerationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TokenGenerationException(String ex) {
        super(ex);
    }
}
