package com.mexpedition.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterExpeditionException extends Throwable {
    public ImpossibleAjouterExpeditionException(String s) {
        super(s);
    }
}
