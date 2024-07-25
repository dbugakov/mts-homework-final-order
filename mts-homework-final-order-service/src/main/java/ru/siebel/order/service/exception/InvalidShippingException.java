package ru.siebel.order.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidShippingException extends ResponseStatusException {
    public InvalidShippingException(String reason) {
        super(HttpStatus.BAD_REQUEST, "Некорректный вид подачи - " + reason);
    }
}
