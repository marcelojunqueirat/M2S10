package com.tech.m2s10.exception;

import org.springframework.security.core.AuthenticationException;

public class AutenticacaoFalhaException extends AuthenticationException {

    public AutenticacaoFalhaException(String msg) {
        super(msg);
    }
}
