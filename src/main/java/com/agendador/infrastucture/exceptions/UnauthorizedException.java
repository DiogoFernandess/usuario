package com.agendador.infrastucture.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {
    public UnauthorizedException(String message) {

        super(message);
    }
    public UnauthorizedException(String message, Throwable throwable) {

        super(message, throwable);
    }

}
