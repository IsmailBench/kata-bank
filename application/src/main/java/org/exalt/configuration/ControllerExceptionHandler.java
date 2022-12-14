package org.exalt.configuration;


import lombok.extern.slf4j.Slf4j;
import org.exalt.exceptions.AccountNotFoundException;
import org.exalt.exceptions.AmountGreaterThanBalanceInOperationException;
import org.exalt.exceptions.NegativeAmountInOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<Object> resourceNotFoundException(AccountNotFoundException accountNotFoundException) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("message", accountNotFoundException.getMessage());
        log.error("ControllerExceptionHandler::AccountNotFoundException : Account not found exception");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NegativeAmountInOperationException.class})
    public ResponseEntity<Object> negativeAmountInOperationException(NegativeAmountInOperationException negativeAmountInOperationException) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("message", negativeAmountInOperationException.getMessage());
        log.error("ControllerExceptionHandler::NegativeAmountInOperationException : Negative amount exception");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AmountGreaterThanBalanceInOperationException.class})
    public ResponseEntity<Object> amountGreaterThanBalanceInOperationException(AmountGreaterThanBalanceInOperationException amountGreaterThanBalanceInOperationException) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("message", amountGreaterThanBalanceInOperationException.getMessage());
        log.error("ControllerExceptionHandler::NegativeAmountInOperationException : Negative amount exception");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
