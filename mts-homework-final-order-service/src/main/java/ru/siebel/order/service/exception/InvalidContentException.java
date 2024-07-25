package ru.siebel.order.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidContentException extends ResponseStatusException {
    public InvalidContentException(String reason) {
        super(HttpStatus.BAD_REQUEST, "Некорректный состав заказа - " + reason);
    }
}
